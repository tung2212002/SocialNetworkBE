package com.tungong.socialnetwork.infrastructure.payload.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageDto {
    String id;

    String url;
}
