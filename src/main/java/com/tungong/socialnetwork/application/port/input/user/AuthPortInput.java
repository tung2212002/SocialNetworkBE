package com.tungong.socialnetwork.application.port.input.user;

import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserDto;
import com.tungong.socialnetwork.infrastructure.payload.request.auth.*;
import com.tungong.socialnetwork.infrastructure.payload.response.auth.RefreshTokenResponse;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface AuthPortInput {
    int MAX_COUNT_OTP = 3;

    UserDto authenticate(AuthRequest authRequest, String userAgent, String fingerprinting);

    String register(RegisterRequest registerRequest, String userAgent, String fingerprinting) throws MessagingException, UnsupportedEncodingException;

    String changePassword(ChangePasswordRequest changePasswordRequest);

    UserDto checkOtpRegister(RegisterRequest registerRequest, String userAgent, String fingerprinting, int attemptCount, Long timeInterval);

    String checkOtpForgotPassword(ForgotPasswordRequest forgotPasswordRequest, int attemptCount, Long timeInterval);

    Void checkOtpDeleteAccount(CheckOtpRequest otpRequest);

    String forgotPassword(ForgotPasswordRequest forgotPasswordRequest) throws MessagingException, UnsupportedEncodingException;

    String deleteAccount() throws MessagingException, UnsupportedEncodingException;

    RefreshTokenResponse refreshToken(String refreshTokenRequest, String fingerprinting);

    String checkSuccessDevice(String key, String userAgent, String fingerprinting);
}
