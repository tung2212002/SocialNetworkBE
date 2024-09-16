package com.tungong.socialnetwork.infrastructure.payload.response.post;

import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserBasicDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentResponse {
    UserBasicDto user;

    Long id;

    Long postId;

    Instant createdAt;

    Instant updatedAt;

    String content;

    Long rootCommentId;

    String image;

    Long repliesQuantity;

    Long reactionsQuantity;

    EReactionType type;
}
