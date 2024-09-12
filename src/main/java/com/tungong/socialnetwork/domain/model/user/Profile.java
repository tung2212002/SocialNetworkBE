package com.tungong.socialnetwork.domain.model.user;

import com.tungong.socialnetwork.domain.model.enums.EGender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Profile {
    Long userId;

    LocalDate birthDate;

    String phoneNumber;

    EGender gender;

    String address;

    Integer cityId;

    Integer districtId;

    String school;

    String job;

    String company;

    String bio;

    Boolean isBirthDatePublic;

    Boolean isPhoneNumberPublic;

    Boolean isGenderPublic;

    Boolean isAddressPublic;

    Boolean isCityPublic;

    Boolean isDistrictPublic;

    Boolean isSchoolPublic;

    Boolean isJobPublic;

    Boolean isCompanyPublic;

    Boolean isBioPublic;
}
