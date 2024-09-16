package com.tungong.socialnetwork.infrastructure.payload.request.auth;

import com.tungong.socialnetwork.common.customAnnotation.constraint.PasswordMatchingConstraint;
import com.tungong.socialnetwork.common.customAnnotation.constraint.PatternConstraint;
import com.tungong.socialnetwork.common.customAnnotation.enums.EPatternValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@PasswordMatchingConstraint(
    password = "newPassword",
    confirmPassword = "confirmPassword"
)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ForgotPasswordRequest {
    @NotBlank(message = "Email cannot be blank")
    @PatternConstraint(EPatternValidator.EMAIL)
    String email;

    @NotBlank(message = "New password cannot be blank")
    @PatternConstraint(EPatternValidator.STRONG_PASSWORD)
    String newPassword;

    @NotBlank(message = "Confirm password cannot be blank")
    String confirmPassword;

    @NotBlank(message = "Otp cannot be blank")
    String otp;
}
