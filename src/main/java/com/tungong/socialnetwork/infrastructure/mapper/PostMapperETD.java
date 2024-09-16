package com.tungong.socialnetwork.infrastructure.mapper;

import com.tungong.socialnetwork.domain.model.enums.EPostStatus;
import com.tungong.socialnetwork.domain.model.post.Post;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EPostStatusEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.post.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapperETD {
//  @Mapping(source = "userEntity.userId", target = "userId")
  Post toDomain(PostEntity postEntity);

//  @Mapping(source = "userId", target = "userEntity.userId")
  PostEntity toEntity(Post post);

  EPostStatus postStatusEntityToPostStatus(EPostStatusEntity postStatusEntity);

  EPostStatusEntity postStatusToPostStatusEntity(EPostStatus postStatus);


//  @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "mapInstantToLocalDateTime")
//  PostNode postEntityToNode(PostEntity post);
//
//  @Named("mapInstantToLocalDateTime")
//  public static LocalDateTime mapInstantToLocalDateTime(Instant instant) {
//    if (instant == null) {
//      return null;
//    }
//    return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//  }
//
//
//  @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "mapInstantToLocalDateTime")
//  PostNode postDomainToNode(Post post);
}