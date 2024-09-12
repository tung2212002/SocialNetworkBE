package com.tungong.socialnetwork.domain.model.post;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {
    Long id;

    Long postId;

    Long userId;

    Long rootCommentId;

    String url;

    String content;

    Long reactionQuantity = 0L;

    Long replyQuantity = 0L;

    Instant createdAt;

    Instant updatedAt;

    public Comment(Long postId, Long userId, String content, Long rootCommentId, String url) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.rootCommentId = rootCommentId;
        this.url = url;
        this.createdAt = Instant.now();
    }

}
