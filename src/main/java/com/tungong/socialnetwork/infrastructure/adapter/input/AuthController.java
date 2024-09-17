package com.tungong.socialnetwork.infrastructure.adapter.input;

import com.tungong.socialnetwork.application.port.input.user.AuthPortInput;
import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import com.tungong.socialnetwork.infrastructure.payload.request.auth.*;
import com.tungong.socialnetwork.infrastructure.payload.response.ApiResponse;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthController {
    final AuthPortInput authPortInput;

    DeviceInfoDto extractDevice(HttpServletRequest request) {
        String agent = request.getHeader("User-Agent");
        String ip = request.getRemoteAddr();
        String fingerprinting = request.getHeader("Fingerprinting");
        return DeviceInfoDto.builder()
                .agent(agent)
                .ip(ip)
                .fingerprinting(fingerprinting)
                .build();
    }

    @PostMapping("/authentication")
    public ApiResponse<?> authenticate(HttpServletRequest request, @Valid @RequestBody AuthRequest authRequest) {
        DeviceInfoDto device = extractDevice(request);
        Object result = authPortInput.authenticate(authRequest, device);
        if (result instanceof String) {
            return ApiResponse.builder()
                    .message((String) result)
                    .build();
        }
        return ApiResponse.builder()
                .result(result)
                .build();
    }

    @PostMapping("/register")
    public ApiResponse<?> register(HttpServletRequest request, @Valid @RequestBody RegisterRequest registerRequest) throws MessagingException, UnsupportedEncodingException {
        DeviceInfoDto device = extractDevice(request);
        return ApiResponse.builder()
                .message(authPortInput.register(registerRequest, device))
                .build();
    }

    @PostMapping("/change-password")
    public ApiResponse<?> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        return ApiResponse.builder()
                .message(authPortInput.changePassword(changePasswordRequest))
                .build();
    }

    @PostMapping("/forgot-password")
    public ApiResponse<?> forgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest) throws MessagingException, UnsupportedEncodingException {
        return ApiResponse.builder()
                .message(authPortInput.forgotPassword(forgotPasswordRequest))
                .build();
    }

    @PostMapping("/register/check-otp")
    public ApiResponse<?> checkOtpRegister(HttpServletRequest request, @Valid @RequestBody CheckOtpRequest checkOtpRequest) {
        DeviceInfoDto device = extractDevice(request);
        return ApiResponse.builder()
                .result(authPortInput.checkOtpRegister(checkOtpRequest, device, AuthPortInput.MAX_COUNT_OTP, 60000L))
                .build();
    }

    @PostMapping("/forgot-password/check-otp")
    public ApiResponse<?> checkOtpForgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        return ApiResponse.builder()
                .result(authPortInput.checkOtpForgotPassword(forgotPasswordRequest, AuthPortInput.MAX_COUNT_OTP, 60000L))
                .build();
    }

    @PostMapping("/delete-account")
    public ApiResponse<?> deleteAccount() throws MessagingException, UnsupportedEncodingException {
        return ApiResponse.builder()
                .result(authPortInput.deleteAccount())
                .build();
    }

    @DeleteMapping("/delete-account/check-otp")
    public ApiResponse<?> checkOtpDeleteAccount(@Valid @RequestBody CheckOtpRequest otpRequest) {
        authPortInput.checkOtpDeleteAccount(otpRequest);
        return ApiResponse.builder().build();
    }

    @GetMapping("/check-success")
    public ApiResponse<?> checkSuccessDevice(@RequestParam String key, HttpServletRequest request) {
        DeviceInfoDto device = extractDevice(request);
        return ApiResponse.builder()
                .result(authPortInput.checkSuccessDevice(key, device.getAgent(), device.getIp(), device.getFingerprinting()))
                .build();
    }

    @GetMapping("/verify-token")
    public ApiResponse<?> verifyToken() {
        return ApiResponse.builder()
                .result(authPortInput.verifyToken())
                .build();
    }

    @PostMapping("/refresh-token")
    public ApiResponse<?> refreshToken(@Valid @RequestBody String refreshTokenRequest, HttpServletRequest request) {
        DeviceInfoDto device = extractDevice(request);
        return ApiResponse.builder()
                .result(authPortInput.refreshToken(refreshTokenRequest, device.getAgent(), device.getIp(), device.getFingerprinting()))
                .build();
    }

//    @GetMapping("/logout")
//    public ApiResponse<?> logout(HttpServletRequest request) {
//        Pair<String, String> device = extractDevice(request);
//        return ApiResponse.builder()
//                .result(authPortInput.logout(device.getFirst(), device.getSecond()))
//                .build();
//    }
}
