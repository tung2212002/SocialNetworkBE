package com.tungong.socialnetwork.application.port.output.user;

import com.tungong.socialnetwork.domain.model.user.Device;
import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;

public interface DevicePort {
    Device save(Device device);

    Device get(DeviceInfoDto device, Long userId);

    String generateOtp();

    void saveOtp(String otp, String userEmail, DeviceInfoDto device);
}
