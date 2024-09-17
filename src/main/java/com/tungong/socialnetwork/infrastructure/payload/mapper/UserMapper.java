package com.tungong.socialnetwork.infrastructure.payload.mapper;

import com.tungong.socialnetwork.domain.model.enums.EGender;
import com.tungong.socialnetwork.domain.model.user.Profile;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.payload.dto.location.CityDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.location.DistrictDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.FieldVisibilityDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userDtoToUserPublicDto(UserDto user);

    @Mapping(target = "birthDate", expression = "java(mapFieldVisibility(user.getBirthDate()))")
    @Mapping(target = "phoneNumber", expression = "java(mapFieldVisibility(user.getPhoneNumber()))")
    @Mapping(target = "gender", expression = "java(mapFieldVisibility(user.getGender()))")
    @Mapping(target = "address", expression = "java(mapFieldVisibility(user.getAddress()))")
    @Mapping(target = "city", expression = "java(mapFieldVisibility(user.getCity()))")
    @Mapping(target = "district", expression = "java(mapFieldVisibility(user.getDistrict()))")
    @Mapping(target = "school", expression = "java(mapFieldVisibility(user.getSchool()))")
    @Mapping(target = "job", expression = "java(mapFieldVisibility(user.getJob()))")
    @Mapping(target = "company", expression = "java(mapFieldVisibility(user.getCompany()))")
    @Mapping(target = "bio", expression = "java(mapFieldVisibility(user.getBio()))")
    UserDto userDtoToUserPrivateDto(UserDto user);

    @Named("mapFieldVisibility")
    default <T> FieldVisibilityDto<T> mapFieldVisibility(FieldVisibilityDto<T> field) {
        FieldVisibilityDto<T> dto;
        if (field != null) {
            if (!field.getVisible()) {
                dto = new FieldVisibilityDto<>(null, false);
            } else {
                dto = new FieldVisibilityDto<>(field.getValue(), true);
            }
            return dto;
        }
        return null;
    }

    @Mapping(target = "birthDate", expression = "java(mapFieldVisibility(profile.getBirthDate(), profile.getIsBirthDatePublic()))")
    @Mapping(target = "phoneNumber", expression = "java(mapFieldVisibility(profile.getPhoneNumber(), profile.getIsPhoneNumberPublic()))")
    @Mapping(target = "gender", expression = "java(mapFieldVisibility(profile.getGender(), profile.getIsGenderPublic()))")
    @Mapping(target = "address", expression = "java(mapFieldVisibility(profile.getAddress(), profile.getIsAddressPublic()))")
    @Mapping(target = "city", expression = "java(mapFieldVisibility(city, profile.getIsCityPublic()))")
    @Mapping(target = "district", expression = "java(mapFieldVisibility(district, profile.getIsDistrictPublic()))")
    @Mapping(target = "school", expression = "java(mapFieldVisibility(profile.getSchool(), profile.getIsSchoolPublic()))")
    @Mapping(target = "job", expression = "java(mapFieldVisibility(profile.getJob(), profile.getIsJobPublic()))")
    @Mapping(target = "company", expression = "java(mapFieldVisibility(profile.getCompany(), profile.getIsCompanyPublic()))")
    @Mapping(target = "bio", expression = "java(mapFieldVisibility(profile.getBio(), profile.getIsBioPublic()))")
    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "firstName", source = "user.firstName")
    @Mapping(target = "lastName", source = "user.lastName")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "profilePicture", source = "user.profilePicture")
    @Mapping(target = "coverPicture", source = "user.coverPicture")
    @Mapping(target = "isPublic", source = "user.isPublic")
    @Mapping(target = "avatar", ignore = true)
    UserDto userAndProfileToUserDto(User user, Profile profile, DistrictDto district, CityDto city);

    default <T> FieldVisibilityDto<T> mapFieldVisibility(T value, Boolean isVisible) {
        return new FieldVisibilityDto<>(isVisible ? value : null, isVisible);
    }

    @Named("mapBirthDate")
    default FieldVisibilityDto<LocalDate> mapDob(Profile profile) {
        return new FieldVisibilityDto<>(profile.getBirthDate(), profile.getIsBirthDatePublic());
    }

    @Named("mapPhoneNumber")
    default FieldVisibilityDto<String> mapPhoneNumber(Profile profile) {
        return new FieldVisibilityDto<>(profile.getPhoneNumber(), profile.getIsPhoneNumberPublic());
    }

    @Named("mapGender")
    default FieldVisibilityDto<EGender> mapGender(Profile profile) {
        return new FieldVisibilityDto<>(profile.getGender(), profile.getIsGenderPublic());
    }

    @Named("mapCity")
    default FieldVisibilityDto<CityDto> mapCity(@Context Profile profile, @Context CityDto city) {
        if (profile == null || city == null) {
            return new FieldVisibilityDto<>(null, false);
        }
        return new FieldVisibilityDto<>(city, profile.getIsCityPublic());
    }

    @Named("mapDistrict")
    default FieldVisibilityDto<DistrictDto> mapDistrict(@Context Profile profile, @Context DistrictDto district) {
        if (profile == null || district == null) {
            return new FieldVisibilityDto<>(null, false);
        }
        return new FieldVisibilityDto<>(district, profile.getIsDistrictPublic());
    }


    @Named("mapSchool")
    default FieldVisibilityDto<String> mapSchool(Profile profile) {
        return new FieldVisibilityDto<>(profile.getSchool(), profile.getIsSchoolPublic());
    }

    @Named("mapJob")
    default FieldVisibilityDto<String> mapJob(Profile profile) {
        return new FieldVisibilityDto<>(profile.getJob(), profile.getIsJobPublic());
    }

    @Named("mapCompany")
    default FieldVisibilityDto<String> mapCompany(Profile profile) {
        return new FieldVisibilityDto<>(profile.getCompany(), profile.getIsCompanyPublic());
    }

    @Named("mapBio")
    default FieldVisibilityDto<String> mapBio(Profile profile) {
        return new FieldVisibilityDto<>(profile.getBio(), profile.getIsBioPublic());
    }
}