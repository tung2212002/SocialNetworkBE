package com.tungong.socialnetwork.infrastructure.payload.dto.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileStateDto {
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
