package com.tungong.socialnetwork.application.port.output.auth;

import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.redis.UserRegisterDataDto;
import com.tungong.socialnetwork.infrastructure.payload.request.auth.RegisterRequest;

public interface OtpPort {
    UserRegisterDataDto getOtpData(String email, String otp, DeviceInfoDto device);

    void deleteAllOtpDataForEmail(String email);

    void deleteOtpData(String email,DeviceInfoDto device);

    void incrementOtpDataCount(String email, DeviceInfoDto device);

    void saveOtp(RegisterRequest registerRequest, String otp, DeviceInfoDto device);

    String generateOtp();

    void sendOtpEmail(String email, String otp);
}
