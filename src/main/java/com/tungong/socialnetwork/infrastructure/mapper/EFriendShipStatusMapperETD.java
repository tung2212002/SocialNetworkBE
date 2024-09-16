package com.tungong.socialnetwork.infrastructure.mapper;

import com.tungong.socialnetwork.domain.model.enums.EFriendshipStatus;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EFriendshipStatusEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EFriendShipStatusMapperETD {
  EFriendshipStatus toDomain(EFriendshipStatusEntity eFriendshipStatusEntity) ;

  EFriendshipStatusEntity toEntity(EFriendshipStatus eFriendshipStatus) ;
}
