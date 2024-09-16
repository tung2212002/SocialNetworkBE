package com.tungong.socialnetwork.infrastructure.payload.request.post;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentPostRequest {
    @NotBlank(message = "Post id cannot be blank")
    Long postId;

    String content;

    String publicId;
}
