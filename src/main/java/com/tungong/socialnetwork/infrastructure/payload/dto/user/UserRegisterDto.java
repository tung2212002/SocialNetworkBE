package com.tungong.socialnetwork.infrastructure.payload.dto.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRegisterDto {
    String firstName;

    String lastName;

    String email;

    String password;
}
