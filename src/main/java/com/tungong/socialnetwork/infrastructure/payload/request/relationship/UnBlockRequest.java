package com.tungong.socialnetwork.infrastructure.payload.request.relationship;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnBlockRequest {
    @NotBlank(message = "User id cannot be null")
    Long userId;
}
