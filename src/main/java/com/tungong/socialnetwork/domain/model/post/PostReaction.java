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
public class PostReaction {
    Long id;

    Long postId;

    Long userId;

    EReactionType reactionType;

    Instant createdAt;

    public PostReaction(Long postId, Long userId, EReactionType reactionType) {
        this.postId = postId;
        this.userId = userId;
        this.reactionType = reactionType;
        this.createdAt = Instant.now();
    }
}
