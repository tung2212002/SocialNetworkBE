package com.tungong.socialnetwork.infrastructure.payload.dto.post;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImagePostDto {
    String publicId;

    String url;
}
