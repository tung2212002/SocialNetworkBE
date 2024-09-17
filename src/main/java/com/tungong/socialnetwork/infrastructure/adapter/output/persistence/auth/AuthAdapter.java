package com.tungong.socialnetwork.infrastructure.adapter.output.persistence.auth;

import com.tungong.socialnetwork.application.port.output.auth.AuthPort;
import com.tungong.socialnetwork.application.port.output.auth.JwtPort;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.adapter.input.sercurity.service.UserDetailsImpl;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.UserEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.UserRepository;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis.RedisAccessTokenRepository;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis.RedisRefreshTokenRepository;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis.RedisUserRepository;
import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.TokenDto;
import com.tungong.socialnetwork.infrastructure.mapper.UserMapperETD;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.util.Pair;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthAdapter implements AuthPort {
    final RedisAccessTokenRepository redisAccessTokenRepository;
    final RedisRefreshTokenRepository redisRefreshTokenRepository;
    final RedisUserRepository redisUserRepository;
    final UserRepository userRepository;
    final JwtPort jwtPort;

    final UserMapperETD userMapperETD;

    @Override
    public User getByEmail(String email) {
        return userMapperETD.toDomain(userRepository.findByEmail(email));
    }

    @Override
    public User saveUser(User user) {
        return userMapperETD.toDomain(userRepository.save(userMapperETD.toEntity(user)));
    }

    @Override
    public Boolean existsUserByUserEmail(String userEmail) {
        return userRepository.existsByEmail(userEmail);
    }

    @Override
    public void changePassword(String newPassword, Long id) {
        userRepository.updatePassword(newPassword, id);
    }

    @Override
    public TokenDto getTokenValid(String jwt, String email) {
        return redisAccessTokenRepository.get(jwt + "_" + email);
    }

    @Override
    public void deleteUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        if (userRepository.existsByEmail(email)) {
            userRepository.delete(user);
        }
    }

    @Override
    public User getUserById(Long id) {
        return userMapperETD.toDomain(userRepository.findById(id).get());
    }

    public User getUserAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return userMapperETD.toDomain(userDetails.getUser());
        }
        return null;
    }

    @Override
    public Boolean isValidRefreshToken(String refreshToken,DeviceInfoDto device) {
        return jwtPort.isValidRefreshToken(refreshToken, device);
    }

    @Override
    public Pair<UserDetailsImpl, String> refreshToken(String refreshToken, String fingerprinting) {
        return null;
    }


    @Override
    public void revokeAllRefreshToken(User user, DeviceInfoDto device) {
        List<String> keys = redisRefreshTokenRepository.getAllKeyByPrefix(user.getEmail());
        for (String key : keys) {
            TokenDto tokenDto = redisRefreshTokenRepository.getFullKey(key);
            if (tokenDto != null && tokenDto.getAgent().equals(device.getAgent()) && tokenDto.getIp().equals(device.getIp()) && tokenDto.getFingerprinting().equals(device.getFingerprinting())) {
                redisRefreshTokenRepository.deleteFullKey(key);
            }
        }
    }

    @Override
    public void saveRefreshToken(User user, DeviceInfoDto device, String refreshToken) {
        TokenDto tokenDto = TokenDto.builder()
                .agent(device.getAgent())
                .ip(device.getIp())
                .fingerprinting(device.getFingerprinting())
                .build();

        redisRefreshTokenRepository.createWithTTL(user.getEmail() + "_" + refreshToken, tokenDto);
    }

    @Override
    public void saveAccessToken(User user, DeviceInfoDto device, String accessToken) {
        TokenDto tokenDto = TokenDto.builder()
                .agent(device.getAgent())
                .ip(device.getIp())
                .fingerprinting(device.getFingerprinting())
                .build();

        redisAccessTokenRepository.createWithTTL(user.getEmail() + "_" + accessToken, tokenDto);
    }

    @Override
    public void revokeAllAccessToken(User user, DeviceInfoDto device) {
        List<String> keys = redisAccessTokenRepository.getAllKeyByPrefix(user.getEmail());
        for (String key : keys) {
            TokenDto tokenDto = redisAccessTokenRepository.getFullKey(key);
            if (tokenDto != null && tokenDto.getAgent().equals(device.getAgent()) && tokenDto.getIp().equals(device.getIp()) && tokenDto.getFingerprinting().equals(device.getFingerprinting())) {
                redisAccessTokenRepository.deleteFullKey(key);
            }
        }
    }

    @Override
    public void revokeAllToken(User user, DeviceInfoDto device) {
        revokeAllAccessToken(user, device);
        revokeAllRefreshToken(user, device);
    }
}
