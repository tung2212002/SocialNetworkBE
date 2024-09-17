package com.tungong.socialnetwork.infrastructure.mapper;


import com.tungong.socialnetwork.domain.model.enums.EGender;
import com.tungong.socialnetwork.domain.model.user.Profile;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EGenderEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.ProfileEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.UserEntity;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserRegisterDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapperETD {
    @Mapping(target = "devices", ignore = true)
    UserEntity toEntity(User user);

    User toDomain(UserEntity userEntity);

    @Mapping(source = "gender", target = "gender", qualifiedByName = "mapGenderToDomain")
    Profile toDomain(ProfileEntity profileEntity);

    @Mapping(source = "gender", target = "gender", qualifiedByName = "mapGenderToEntity")
    @Mapping(target = "userEntity", ignore = true)
    ProfileEntity toEntity(Profile profile);

    UserEntity toEntity(UserRegisterDto userRegisterDto);

    @Named("mapGenderToDomain")
    EGender mapGenderToDomain(EGenderEntity gender);

    @Named("mapGenderToEntity")
    EGenderEntity mapGenderToEntity(EGender gender);

}
