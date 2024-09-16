package com.tungong.socialnetwork.infrastructure.payload.mapper;

import com.tungong.socialnetwork.domain.model.enums.EFriendshipStatus;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.payload.dto.relationship.FriendShipUserDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserBasicDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface RelationshipMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "profilePicture", source = "profilePicture")
    UserBasicDto userToUserDto(User user);

    @Mapping(source = "user", target = "user")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "mutualFriends", target = "mutualFriends")
    FriendShipUserDto toFriendShipUserDto(User user, EFriendshipStatus status, Long mutualFriends);

}
