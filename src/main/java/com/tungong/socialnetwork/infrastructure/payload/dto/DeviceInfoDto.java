package com.tungong.socialnetwork.infrastructure.payload.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceInfoDto {
    String ip;
    String fingerprinting;
    String agent;
}
