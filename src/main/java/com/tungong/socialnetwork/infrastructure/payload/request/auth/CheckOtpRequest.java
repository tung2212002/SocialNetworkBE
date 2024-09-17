package com.tungong.socialnetwork.infrastructure.payload.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckOtpRequest {
    @NotBlank(message = "Otp cannot be blank")
    String otp;

    @NotBlank(message = "Email cannot be blank")
    String email;
}
