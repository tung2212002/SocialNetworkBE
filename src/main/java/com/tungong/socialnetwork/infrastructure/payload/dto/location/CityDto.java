package com.tungong.socialnetwork.infrastructure.payload.dto.location;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityDto {
    Long id;

    String name;

    String code;

    String nameWithType;

    String slug;

    String type;

    Integer cityId;
}
