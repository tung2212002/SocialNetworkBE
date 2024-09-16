package com.tungong.socialnetwork.infrastructure.payload.request.post;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReplyCommentRequest {
    @NotNull(message = "Comment id cannot be null")
    Long commentId;

    String content;

    String publicId;
}
