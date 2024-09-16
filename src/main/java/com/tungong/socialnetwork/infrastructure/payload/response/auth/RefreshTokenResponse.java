package com.tungong.socialnetwork.infrastructure.payload.response.auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshTokenResponse {
    String accessToken;

    String tokenType = "Bearer";
}
