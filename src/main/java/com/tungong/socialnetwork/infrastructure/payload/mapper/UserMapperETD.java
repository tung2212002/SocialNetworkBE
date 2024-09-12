package com.tungong.socialnetwork.infrastructure.payload.mapper;


import com.tungong.socialnetwork.domain.model.enums.EGender;
import com.tungong.socialnetwork.domain.model.user.Profile;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EGenderEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.ProfileEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.UserEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapperETD {

    UserEntity toEntity(User user);

    User toDomain(UserEntity userEntity);

    @Mapping(source = "gender", target = "gender", qualifiedByName = "mapGenderToDomain")
    Profile toDomain(ProfileEntity profileEntity);

    @Mapping(source = "gender", target = "gender", qualifiedByName = "mapGenderToEntity")
    ProfileEntity toEntity(Profile profile);

    @Named("mapGenderToDomain")
    EGender mapGenderToDomain(EGenderEntity gender);

    @Named("mapGenderToEntity")
    EGenderEntity mapGenderToEntity(EGender gender);
}
