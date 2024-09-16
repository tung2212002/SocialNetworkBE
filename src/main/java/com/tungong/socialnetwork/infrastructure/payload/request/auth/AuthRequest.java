package com.tungong.socialnetwork.infrastructure.payload.request.auth;

import com.tungong.socialnetwork.common.customAnnotation.constraint.PatternConstraint;
import com.tungong.socialnetwork.common.customAnnotation.enums.EPatternValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthRequest {
    @NotBlank(message = "Email cannot be blank")
    @PatternConstraint(EPatternValidator.EMAIL)
    String email;

    @NotBlank(message = "Password cannot be blank")
    String password;
}
