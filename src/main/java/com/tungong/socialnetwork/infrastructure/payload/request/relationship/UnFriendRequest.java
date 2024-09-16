package com.tungong.socialnetwork.infrastructure.payload.request.relationship;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnFriendRequest {
    @NotBlank(message = "Friend id cannot be null")
    Long friendId;
}
