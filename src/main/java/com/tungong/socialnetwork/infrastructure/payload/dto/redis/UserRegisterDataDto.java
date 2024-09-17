package com.tungong.socialnetwork.infrastructure.payload.dto.redis;

import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserRegisterDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRegisterDataDto {
    UserRegisterDto user;

    Integer count;

    String otp;

    String ip;

    String fingerprinting;

    String agent;

}
