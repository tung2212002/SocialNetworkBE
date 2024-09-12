package com.tungong.socialnetwork.common.customAnnotation.constraint;

import com.tungong.socialnetwork.common.customAnnotation.enums.EPatternValidator;
import com.tungong.socialnetwork.common.customAnnotation.validator.PatternValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PatternValidator.class})
public @interface PatternConstraint {
    String message() default "Invalid format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    EPatternValidator value();
}
