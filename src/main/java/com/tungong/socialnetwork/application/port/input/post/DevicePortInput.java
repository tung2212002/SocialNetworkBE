package com.tungong.socialnetwork.application.port.input.post;

import java.util.Map;

public interface DevicePortInput {
    String checkDeviceOtp(int otp);

    Map<String, Object> generateOtp(int cnt);
}
