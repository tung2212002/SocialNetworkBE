package com.tungong.socialnetwork.infrastructure.payload.request.user;

import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchUserRequest extends PaginationRequest {
    @NotBlank(message = "Search key cannot be null")
    String searchKey;
}
