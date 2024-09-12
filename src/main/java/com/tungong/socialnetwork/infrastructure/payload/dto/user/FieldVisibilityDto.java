package com.tungong.socialnetwork.infrastructure.payload.dto.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FieldVisibilityDto<T> {
    T value;
    Boolean visible;
}
