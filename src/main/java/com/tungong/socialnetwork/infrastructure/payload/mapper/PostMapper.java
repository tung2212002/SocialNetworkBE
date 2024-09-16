package com.tungong.socialnetwork.infrastructure.payload.mapper;

import com.tungong.socialnetwork.domain.model.enums.EPostStatus;
import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import com.tungong.socialnetwork.domain.model.post.Post;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.payload.dto.ImageDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.post.ImagePostDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.post.PostBasicDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserBasicDto;
import com.tungong.socialnetwork.infrastructure.payload.response.post.PostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(source = "post.id", target = "id")
    @Mapping(source = "post.content", target = "content")
    @Mapping(source = "post.createdAt", target = "createdAt")
    @Mapping(source = "post.updatedAt", target = "updatedAt")
    @Mapping(source = "post.status", target = "status", qualifiedByName = "statusToString")
    @Mapping(source = "images", target = "images")
    @Mapping(source = "tagUsers", target = "tagUsers", qualifiedByName = "mapTagUsers")
    @Mapping(source = "post.reactionQuantity", target = "reactionsQuantity")
    @Mapping(source = "post.commentQuantity", target = "commentsQuantity")
    PostResponse postToPostResponse(Post post, List<ImageDto> images, List<?> tagUsers, UserBasicDto user, EReactionType type);

    @Named("statusToString")
    default String postStatusToString(EPostStatus postStatus) {
        return postStatus != null ? postStatus.name() : null;
    }

    @Named("mapTagUsers")
    default List<UserBasicDto> mapTagUsers(List<?> tagUsers) {
        if (tagUsers == null) {
            return null;
        }
        if (tagUsers.isEmpty()) {
            return List.of();
        }
        if (tagUsers.get(0) instanceof UserBasicDto) {
            return (List<UserBasicDto>) tagUsers;
        } else if (tagUsers.get(0) instanceof User) {
            return ((List<User>) tagUsers).stream()
                    .map(this::userToUserBasicInfoDto)
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    UserBasicDto userToUserBasicInfoDto(User user);

    PostBasicDto postToPostBasicDto(Post post);
}