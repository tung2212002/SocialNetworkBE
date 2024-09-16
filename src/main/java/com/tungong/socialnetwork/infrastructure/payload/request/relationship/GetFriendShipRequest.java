package com.tungong.socialnetwork.infrastructure.payload.request.relationship;

import com.tungong.socialnetwork.common.customAnnotation.constraint.PatternConstraint;
import com.tungong.socialnetwork.common.customAnnotation.enums.EPatternValidator;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetFriendShipRequest {
    @PatternConstraint(EPatternValidator.FILTER_FRIEND_STATUS)
    String status;

    @Nullable
    Long userId;
}
