package com.tungong.socialnetwork.infrastructure.mapper;

import com.tungong.socialnetwork.domain.model.post.Comment;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.post.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CommentMapperETD {
//
//  @Mapping(source = "entity.userId", target = "userId")
//  @Mapping(source = "entity.postId", target = "postId")
//  @Mapping(source = "rootCommentEntity", target = "rootCommentId", qualifiedByName = "rootCommentToId")
  Comment toDomain(CommentEntity entity);

//  @Mapping(source = "userId", target = "userEntity.userId")
//  @Mapping(source = "postId", target = "postEntity.postId")
//  @Mapping(source = "rootCommentId", target = "rootCommentEntity", qualifiedByName = "idToRootComment")
//  @Mapping(target = "childCommentEntities", ignore = true)
//  @Mapping(target = "reactionCommentEntities", ignore = true)
  CommentEntity toEntity(Comment model);

//  @Named("rootCommentToId")
//  default Long rootCommentToId(CommentEntity rootComment) {
//    return rootComment != null ? rootComment.getId() : null;
//  }

//  @Named("idToRootComment")
//  default CommentEntity idToRootComment(Long rootCommentId) {
//    if (rootCommentId == null) {
//      return null;
//    }
//    CommentEntity rootComment = new CommentEntity();
//    rootComment.setId(rootCommentId);
//    return rootComment;
//  }

//  @Mapping(source = "commentId", target = "commentId")
//  @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "mapInstantToLocalDateTime")
//  CommentNode commentEntityToNode(CommentEntity commentEntity);
//
//  @Named("mapInstantToLocalDateTime")
//  public static LocalDateTime mapInstantToLocalDateTime(Instant instant) {
//    if (instant == null) {
//      return null;
//    }
//    System.out.println(ZoneId.systemDefault());
//    return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//  }
}