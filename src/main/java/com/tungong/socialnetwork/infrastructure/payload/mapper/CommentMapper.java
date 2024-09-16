package com.tungong.socialnetwork.infrastructure.payload.mapper;

import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import com.tungong.socialnetwork.domain.model.post.Comment;
import com.tungong.socialnetwork.domain.model.post.Post;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserBasicDto;
import com.tungong.socialnetwork.infrastructure.payload.response.post.ActivityInteractionResponse;
import com.tungong.socialnetwork.infrastructure.payload.response.post.CommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", source = "comment.id")
    @Mapping(target = "postId", source = "comment.postId")
    @Mapping(target = "createdAt", source = "comment.createdAt")
    @Mapping(target = "updatedAt", source = "comment.updatedAt")
    @Mapping(target = "content", source = "comment.content")
    @Mapping(target = "rootCommentId", source = "comment.rootCommentId")
    @Mapping(target = "image", source = "comment.url")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "reactionsQuantity", source = "comment.reactionQuantity")
    @Mapping(target = "repliesQuantity", source = "comment.replyQuantity")
    @Mapping(target = "user", source = "userBasicDto")
    CommentResponse commentToCommentResponse(Comment comment, UserBasicDto userBasicDto, EReactionType type);

    @Mapping(target = "user", ignore = true)
    CommentResponse commentToCommentResponse(Comment commentParent, List<Comment> childComments);

    @Mapping(target = "roleId", source = "comment.id")
    @Mapping(target = "createdAt", source = "comment.createdAt")
    @Mapping(target = "content", source = "comment.content")
    @Mapping(target = "rootCommentId", source = "comment.rootCommentId")
    @Mapping(target = "image", source = "comment.url")
    ActivityInteractionResponse commentToCommentActivityResponse(Comment comment, User user, Post post, String role);
}
