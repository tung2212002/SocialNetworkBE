package com.tungong.socialnetwork.domain.model.post;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostTagUser {
    Long id;

    Long postId;

    Long userId;
}
