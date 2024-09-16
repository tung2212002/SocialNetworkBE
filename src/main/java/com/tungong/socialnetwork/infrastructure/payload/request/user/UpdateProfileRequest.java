package com.tungong.socialnetwork.infrastructure.payload.request.user;

import com.tungong.socialnetwork.common.customAnnotation.constraint.BirthDateConstraint;
import com.tungong.socialnetwork.common.customAnnotation.constraint.PatternConstraint;
import com.tungong.socialnetwork.common.customAnnotation.enums.EPatternValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProfileRequest {
    @NotBlank(message = "First name cannot be null")
    String firstName;

    @NotBlank(message = "Last name cannot be null")
    String lastName;

    @PatternConstraint(EPatternValidator.PHONE_NUMBER)
    String phoneNumber;

    @BirthDateConstraint
    String birthDate;

    @PatternConstraint(EPatternValidator.GENDER)
    String gender;

    String address;

    Integer cityId;

    Integer districtId;

    String school;

    String job;

    String company;

    String bio;
}
