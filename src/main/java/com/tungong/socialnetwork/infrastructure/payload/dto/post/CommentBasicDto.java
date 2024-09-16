package com.tungong.socialnetwork.infrastructure.payload.dto.post;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentBasicDto {
    Long id;

    String content;

    Instant createdAt;

    String image;

    Long rootCommentId;

    Long postId;
}
