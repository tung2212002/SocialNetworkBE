package com.tungong.socialnetwork.common.customAnnotation.constraint;

import com.tungong.socialnetwork.common.customAnnotation.validator.PasswordMatchingValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordMatchingValidator.class})
public @interface PasswordMatchingConstraint {
    String password();

    String confirmPassword();

    String message() default "Passwords do not match";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
