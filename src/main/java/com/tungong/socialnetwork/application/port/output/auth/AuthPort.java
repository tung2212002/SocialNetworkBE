package com.tungong.socialnetwork.application.port.output.auth;


import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.adapter.input.sercurity.service.UserDetailsImpl;
import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.TokenDto;
import org.springframework.data.util.Pair;

import java.util.Map;
import java.util.Set;

public interface AuthPort {
    User getByEmail(String email);

    User saveUser(User user);

    Boolean existsUserByUserEmail(String email);

    void changePassword(String newPassword, Long id);

    TokenDto getTokenValid(String jwt, String email);

    void deleteUserByEmail(String email);

    User getUserById(Long id);

    User getUserAuth();

    Boolean isValidRefreshToken(String refreshToken, DeviceInfoDto device);

    Pair<UserDetailsImpl, String> refreshToken(String refreshToken, String fingerprinting);

    void revokeAllRefreshToken(User user, DeviceInfoDto device);

    void saveRefreshToken(User user, DeviceInfoDto device, String refreshToken);

    void saveAccessToken(User user, DeviceInfoDto device, String accessToken);

    void revokeAllAccessToken(User user, DeviceInfoDto device);

    void revokeAllToken(User user, DeviceInfoDto device);
}
