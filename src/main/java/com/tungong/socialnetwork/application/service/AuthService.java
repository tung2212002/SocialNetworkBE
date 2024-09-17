package com.tungong.socialnetwork.application.service;

import com.tungong.socialnetwork.application.port.input.user.AuthPortInput;
import com.tungong.socialnetwork.application.port.output.auth.AuthPort;
import com.tungong.socialnetwork.application.port.output.auth.JwtPort;
import com.tungong.socialnetwork.application.port.output.auth.OtpPort;
import com.tungong.socialnetwork.application.port.output.user.DevicePort;
import com.tungong.socialnetwork.application.port.output.user.ProfilePort;
import com.tungong.socialnetwork.common.customException.CustomException;
import com.tungong.socialnetwork.common.customException.ErrorCode;
import com.tungong.socialnetwork.domain.event.user.CreateUserEvent;
import com.tungong.socialnetwork.domain.model.enums.EDeviceType;
import com.tungong.socialnetwork.domain.model.location.City;
import com.tungong.socialnetwork.domain.model.location.District;
import com.tungong.socialnetwork.domain.model.user.Device;
import com.tungong.socialnetwork.domain.model.user.Profile;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.location.CityDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.location.DistrictDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.redis.UserRegisterDataDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserRegisterDto;
import com.tungong.socialnetwork.infrastructure.payload.mapper.UserMapper;
import com.tungong.socialnetwork.infrastructure.payload.request.auth.*;
import com.tungong.socialnetwork.infrastructure.payload.response.auth.AuthResponse;
import com.tungong.socialnetwork.infrastructure.payload.response.auth.RefreshTokenResponse;
import jakarta.mail.MessagingException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthService implements AuthPortInput {
    final AuthenticationManager authenticationManager;

    final AuthPort authPort;
    final OtpPort otpPort;
    final DevicePort devicePort;
    final JwtPort jwtPort;
    final ProfilePort profilePort;
    final ApplicationEventPublisher applicationEventPublisher;
    final PasswordEncoder passwordEncoder;

    final UserMapper userMapper;

    @Override
    public Object authenticate(AuthRequest authRequest, DeviceInfoDto device) {
        User user = getUserByEmail(authRequest.getEmail());
        authenticateUser(authRequest.getEmail(), authRequest.getPassword());

        if (isNewDevice(device, user.getId())) {
            return handleNewDevice(authRequest.getEmail(), device);
        }

        return authenticationWithDeviceTrust(user, device);
    }

    @Override
    public String register(RegisterRequest registerRequest, DeviceInfoDto device) throws MessagingException, UnsupportedEncodingException {
        if (authPort.existsUserByUserEmail(registerRequest.getEmail())) {
            throw new CustomException(ErrorCode.USER_EXISTED);
        }

        String otp = otpPort.generateOtp();
        otpPort.saveOtp(registerRequest, otp, device);
        otpPort.sendOtpEmail(registerRequest.getEmail(), otp);

        return "OTP sent to email";
    }

    @Override
    public String changePassword(ChangePasswordRequest changePasswordRequest) {
        return null;
    }

    @Override
    public String checkOtpRegister(CheckOtpRequest checkOtpRequest, DeviceInfoDto device, int attemptCount, Long timeInterval) {
        String email = checkOtpRequest.getEmail();
        String otp = checkOtpRequest.getOtp();

        UserRegisterDataDto userRegisterDataDto = otpPort.getOtpData(email, otp, device);
        if (userRegisterDataDto == null) {
            throw new CustomException(ErrorCode.NOT_FOUND);
        }
        if (userRegisterDataDto.getCount() >= attemptCount) {
            throw new CustomException(ErrorCode.MAXIMUM_NUMBER_REQUEST_OTP);
        }

        if (!userRegisterDataDto.getOtp().equals(otp)) {
            otpPort.incrementOtpDataCount(email, device);
            throw new CustomException(ErrorCode.CODE_VERIFY_INCORRECT);
        }

        User user = createAndSaveUser(userRegisterDataDto.getUser());
        saveNewDevice(device.getFingerprinting(), device.getAgent(), device.getIp(), user.getId());
        otpPort.deleteAllOtpDataForEmail(email);

        applicationEventPublisher.publishEvent(new CreateUserEvent(user));
        System.out.println("CreateUserEvent");
        return "Register successfully";
    }

    @Override
    public String checkOtpForgotPassword(ForgotPasswordRequest forgotPasswordRequest, int attemptCount, Long timeInterval) {
        return null;
    }

    @Override
    public Void checkOtpDeleteAccount(CheckOtpRequest otpRequest) {
        return null;
    }

    @Override
    public String forgotPassword(ForgotPasswordRequest forgotPasswordRequest) throws MessagingException, UnsupportedEncodingException {
        return null;
    }

    @Override
    public String deleteAccount() throws MessagingException, UnsupportedEncodingException {
        return null;
    }

    @Override
    public RefreshTokenResponse refreshToken(String refreshTokenRequest, String agent, String ip, String fingerprinting) {
        return null;
    }

    @Override
    public UserDto verifyToken() {
        User user = authPort.getUserAuth();
        return getUserDto(user);
    }

    @Override
    public String checkSuccessDevice(String key, String agent, String ip, String fingerprinting) {
        return null;
    }

    private User createAndSaveUser(UserRegisterDto user) {
        User newUser = new User().builder()
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();

        return authPort.saveUser(newUser);
    }

    private void saveNewDevice(String fingerprinting, String agent, String ip, Long userId) {
        Device device = new Device().builder()
                .userId(userId)
                .fingerprinting(fingerprinting)
                .agent(agent)
                .ip(ip)
                .userId(userId)
                .deviceType(EDeviceType.DEFAULT)
                .build();
        devicePort.save(device);
    }

    private void authenticateUser(String email, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (BadCredentialsException e) {
            throw new CustomException(ErrorCode.AUTHENTICATION_FAILED);
        }
    }

    private User getUserByEmail(String email) {
        User user = authPort.getByEmail(email);
        if (user == null) {
            throw new CustomException(ErrorCode.EMAIL_NOT_EXISTED);
        }
        return user;
    }

    private boolean isNewDevice(DeviceInfoDto device, Long userId) {
        return devicePort.get(device, userId) == null;
    }

    private AuthResponse authenticationWithDeviceTrust(User user, DeviceInfoDto device) {
        String accessToken = jwtPort.generateToken(user, device);
        String refreshToken = jwtPort.generateRefreshToken(user, device);

        authPort.revokeAllToken(user, device);
        authPort.saveRefreshToken(user, device, refreshToken);
        authPort.saveAccessToken(user, device, accessToken);

        return new AuthResponse().builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .user(getUserDto(user))
                .build();
    }

    private String handleNewDevice(String userEmail, DeviceInfoDto device) {
        String otp = devicePort.generateOtp();

        devicePort.saveOtp(otp, userEmail, device);
        // send otp to default device
        return "OTP sent to default device: " + otp;
    }

    private UserDto getUserDto(User user) {
        Profile profile = profilePort.getProfileById(user.getId());
        Integer districtId = profile.getDistrictId();
        Integer cityId = profile.getCityId();

        DistrictDto district = null;
        CityDto city = null;

        return userMapper.userAndProfileToUserDto(user, profile, null, null);
    }
}
