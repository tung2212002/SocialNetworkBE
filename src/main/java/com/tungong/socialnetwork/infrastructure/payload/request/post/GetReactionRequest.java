package com.tungong.socialnetwork.infrastructure.payload.request.post;

import com.tungong.socialnetwork.common.customAnnotation.constraint.PatternConstraint;
import com.tungong.socialnetwork.common.customAnnotation.enums.EPatternValidator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetReactionRequest {
    @PatternConstraint(EPatternValidator.REACTION_TYPE)
    String type;
}
