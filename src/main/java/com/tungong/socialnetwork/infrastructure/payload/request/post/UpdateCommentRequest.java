package com.tungong.socialnetwork.infrastructure.payload.request.post;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateCommentRequest {
    String content;

    String publicId;
}
