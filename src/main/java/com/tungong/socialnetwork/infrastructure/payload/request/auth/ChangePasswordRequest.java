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
        password = "newPassword",
        confirmPassword = "confirmPassword"
)
public class ChangePasswordRequest {
    @NotBlank(message = "Old password cannot be blank")
    String oldPassword;

    @NotBlank(message = "New password cannot be blank")
    @PatternConstraint(EPatternValidator.STRONG_PASSWORD)
    String newPassword;

    @NotBlank(message = "Confirm password cannot be blank")
    String confirmPassword;
}
