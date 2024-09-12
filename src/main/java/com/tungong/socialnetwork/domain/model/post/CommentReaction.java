package com.tungong.socialnetwork.domain.model.post;

import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentReaction {
    Long id;

    Long commentId;

    Long userId;

    EReactionType reactionType;

    Instant createdAt;

    public CommentReaction(Long commentId, Long userId, EReactionType reactionType) {
        this.commentId = commentId;
        this.userId = userId;
        this.reactionType = reactionType;
        this.createdAt = Instant.now();
    }
}
