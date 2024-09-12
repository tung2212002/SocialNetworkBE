package com.tungong.socialnetwork.infrastructure.payload.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TokenDto {
    String token;
    Long expiresIn;
    String tokenType = "Bearer";
}
