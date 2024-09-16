package com.tungong.socialnetwork.infrastructure.payload.request.auth;

import com.tungong.socialnetwork.common.customAnnotation.constraint.PasswordMatchingConstraint;
import com.tungong.socialnetwork.common.customAnnotation.constraint.PatternConstraint;
import com.tungong.socialnetwork.common.customAnnotation.enums.EPatternValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@PasswordMatchingConstraint(
        password = "password",
        confirmPassword = "confirmPassword"
)
public class RegisterRequest {
    @NotBlank(message = "First name cannot be blank")
    String firstName;

    @NotBlank(message = "Last name cannot be blank")
    String lastName;

    @NotBlank(message = "Email cannot be blank")
    @PatternConstraint(EPatternValidator.EMAIL)
    String email;

    @NotBlank(message = "Password cannot be blank")
    @PatternConstraint(EPatternValidator.STRONG_PASSWORD)
    String password;

    @NotBlank(message = "Confirm password cannot be blank")
    String confirmPassword;
}
