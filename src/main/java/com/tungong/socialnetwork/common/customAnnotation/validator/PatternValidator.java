package com.tungong.socialnetwork.common.customAnnotation.validator;

import com.tungong.socialnetwork.common.customAnnotation.constraint.PatternConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PatternValidator implements ConstraintValidator<PatternConstraint, String> {
    private String regex;
    private String message;

    @Override
    public void initialize(PatternConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.regex = constraintAnnotation.value().getPattern();
        this.message = constraintAnnotation.value().getMessage();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }

        boolean isValid = s.matches(regex);
        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addConstraintViolation();
        }
        return isValid;
    }
}
