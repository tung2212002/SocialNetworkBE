package com.tungong.socialnetwork.infrastructure.payload.mapper;

import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import com.tungong.socialnetwork.domain.model.post.Post;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.payload.dto.post.ReactionCountDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.post.ReactionUserDto;
import com.tungong.socialnetwork.infrastructure.payload.response.post.ActivityInteractionResponse;
import com.tungong.socialnetwork.infrastructure.payload.response.post.ReactionCommentResponse;
import com.tungong.socialnetwork.infrastructure.payload.response.post.ReactionPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReactionMapper {
    ReactionCommentResponse toReactionCommentResponse(ReactionCommentResponse reactionComment);

    ReactionUserDto toReactionInfoResponse(User user, EReactionType type);

    @Mapping(target = "roleId", source = "reactionId")
    @Mapping(target = "createdAt", source = "createdAt")
    ActivityInteractionResponse toReactionActivityResponse(Long reactionId, EReactionType eReactionType, String imageUrl, Instant createdAt, Long parentCommentId, User user, Post post, String role);

    @Mapping(source = "postId", target = "roleId")
    ReactionPostResponse toReactionPostResponse(Long postId, List<ReactionUserDto> users, List<ReactionCountDto> reactions);
}
