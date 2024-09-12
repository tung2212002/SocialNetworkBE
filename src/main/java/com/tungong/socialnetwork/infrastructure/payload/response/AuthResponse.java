package com.tungong.socialnetwork.infrastructure.payload.response;

import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserBasicDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthResponse {
    String accessToken;

    String refreshToken;

    String tokenType = "Bearer";

    UserBasicDto user;
}
