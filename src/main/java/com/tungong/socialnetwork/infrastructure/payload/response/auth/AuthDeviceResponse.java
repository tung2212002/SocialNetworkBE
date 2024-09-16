package com.tungong.socialnetwork.infrastructure.payload.response.auth;

import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthDeviceResponse {
    String otp;

    String key;
}
