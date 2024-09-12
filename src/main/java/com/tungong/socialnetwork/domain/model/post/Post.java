package com.tungong.socialnetwork.domain.model.post;

import com.tungong.socialnetwork.domain.model.enums.EPostStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    Long id;

    Long userId;

    String content;

    EPostStatus status;

    Long reactionQuantity = 0L;

    Long commentQuantity = 0L;

    Instant createdAt;

    Instant updatedAt;

    public Post(Long userId, String content) {
        this.userId = userId;
        this.content = content;
        this.createdAt = Instant.now();
    }

}
