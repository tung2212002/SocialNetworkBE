package com.tungong.socialnetwork.infrastructure.payload.request.relationship;

import com.tungong.socialnetwork.common.customAnnotation.constraint.PatternConstraint;
import com.tungong.socialnetwork.common.customAnnotation.enums.EPatternValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SetRequestFriendRequest {
    Long friendId;

    @PatternConstraint(EPatternValidator.UPDATE_FRIEND_STATUS)
    @NotBlank(message = "Status cannot be null")
    String status;
}
