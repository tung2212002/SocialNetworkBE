package com.tungong.socialnetwork.infrastructure.payload.request.post;

import com.tungong.socialnetwork.common.customAnnotation.constraint.PatternConstraint;
import com.tungong.socialnetwork.common.customAnnotation.enums.EPatternValidator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateOrUpdatePostRequest {
    String content;

    @PatternConstraint(EPatternValidator.POST_STATUS)
    String status = "PUBLIC";

    List<Long> tagUserIds = new ArrayList<>();

    List<Long> imgIds = new ArrayList<>();

    List<String> publicIds = new ArrayList<>();
}
