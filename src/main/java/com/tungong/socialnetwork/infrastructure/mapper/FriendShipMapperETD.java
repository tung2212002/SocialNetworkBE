package com.tungong.socialnetwork.infrastructure.mapper;

import com.tungong.socialnetwork.domain.model.relationship.Friendship;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.friendship.FriendshipEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FriendShipMapperETD {
  Friendship toDomain(FriendshipEntity friendShipEntity);

  FriendshipEntity toEntity(Friendship friendShip);
}
