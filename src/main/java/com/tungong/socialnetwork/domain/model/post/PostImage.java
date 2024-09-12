package com.tungong.socialnetwork.domain.model.post;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostImage {
    Long id;

    Long postId;

    String url;

    Integer position;
}
