package com.tungong.socialnetwork.infrastructure.payload.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SetProfileStateRequest {
    @NotBlank(message = "isPublic cannot be null")
    Boolean isPublic;
}
