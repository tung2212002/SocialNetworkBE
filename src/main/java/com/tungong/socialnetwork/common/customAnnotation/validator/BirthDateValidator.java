package com.tungong.socialnetwork.common.customAnnotation.validator;

import com.tungong.socialnetwork.common.customAnnotation.constraint.BirthDateConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.util.Objects;

public class BirthDateValidator implements ConstraintValidator<BirthDateConstraint, LocalDate> {
    private int min;

    @Override
    public void initialize(BirthDateConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(localDate)) {
            return true;
        }

        boolean isValid = localDate.isBefore(LocalDate.now().minusYears(min));
        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Date of birth must be at least " + min + " years ago")
                    .addConstraintViolation();
        }
        return isValid;
    }
}
