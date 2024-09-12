package com.tungong.socialnetwork.domain.model.location;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City {
    Long id;

    String name;

    String code;

    String nameWithType;

    String slug;

    String type;

    String country;
}
