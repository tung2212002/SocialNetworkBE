package com.tungong.socialnetwork.infrastructure.payload.dto.user;

import com.tungong.socialnetwork.domain.model.enums.EGender;
import com.tungong.socialnetwork.domain.model.enums.EUserRole;
import com.tungong.socialnetwork.domain.model.enums.EUserStatus;
import com.tungong.socialnetwork.infrastructure.payload.dto.location.CityDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.location.DistrictDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Long id;

    String firstName;

    String lastName;

    String email;

    String avatar;

    String profilePicture;

    String coverPicture;

    Boolean isPublic;

    EUserStatus status;

    EUserRole role;

    FieldVisibilityDto<LocalDate> birthDate;

    FieldVisibilityDto<String> phoneNumber;

    FieldVisibilityDto<EGender> gender;

    FieldVisibilityDto<String> address;

    FieldVisibilityDto<CityDto> city;

    FieldVisibilityDto<DistrictDto> district;

    FieldVisibilityDto<String> school;

    FieldVisibilityDto<String> job;

    FieldVisibilityDto<String> company;

    FieldVisibilityDto<String> bio;
}
