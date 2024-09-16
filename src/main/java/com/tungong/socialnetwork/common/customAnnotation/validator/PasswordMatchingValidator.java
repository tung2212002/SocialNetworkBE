package com.tungong.socialnetwork.common.customAnnotation.validator;

import com.tungong.socialnetwork.common.customAnnotation.constraint.PasswordMatchingConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatchingConstraint, Object> {
    private String password;

    private String confirmPassword;

    @Override
    public void initialize(PasswordMatchingConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        password = constraintAnnotation.password();
        confirmPassword = constraintAnnotation.confirmPassword();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null) {
            return false;
        }

        Object passwordValue = new BeanWrapperImpl(o).getPropertyValue(password);
        Object confirmPasswordValue = new BeanWrapperImpl(o).getPropertyValue(confirmPassword);

        boolean isValid = passwordValue != null && passwordValue.equals(confirmPasswordValue);
        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Passwords do not match")
                    .addConstraintViolation();
        }
        return isValid;
    }
}
