package com.tungong.socialnetwork.domain.model.user;

import com.tungong.socialnetwork.domain.model.enums.EDeviceType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Device {
    Long id;

    Long userId;

    String fingerprinting;

    String agent;

    String ip;

    String deviceInfo;

    EDeviceType deviceType;

    Instant createdAt;

    Instant updatedAt;
}
