package com.tungong.socialnetwork.application.port.input.user;

import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserDto;
import com.tungong.socialnetwork.infrastructure.payload.request.auth.*;
import com.tungong.socialnetwork.infrastructure.payload.response.auth.RefreshTokenResponse;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface AuthPortInput {
    int MAX_COUNT_OTP = 3;

    Object authenticate(AuthRequest authRequest, DeviceInfoDto device);

    String register(RegisterRequest registerRequest, DeviceInfoDto device) throws MessagingException, UnsupportedEncodingException;

    String changePassword(ChangePasswordRequest changePasswordRequest);

    String checkOtpRegister(CheckOtpRequest checkOtpRequest, DeviceInfoDto device, int attemptCount, Long timeInterval);

    String checkOtpForgotPassword(ForgotPasswordRequest forgotPasswordRequest, int attemptCount, Long timeInterval);

    Void checkOtpDeleteAccount(CheckOtpRequest otpRequest);

    String forgotPassword(ForgotPasswordRequest forgotPasswordRequest) throws MessagingException, UnsupportedEncodingException;

    String deleteAccount() throws MessagingException, UnsupportedEncodingException;

    RefreshTokenResponse refreshToken(String refreshTokenRequest, String agent,String ip, String fingerprinting);

    UserDto verifyToken();

    String checkSuccessDevice(String key, String agent, String ip, String fingerprinting);
}
