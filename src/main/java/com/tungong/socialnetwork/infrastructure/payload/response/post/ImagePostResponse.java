package com.tungong.socialnetwork.infrastructure.payload.response.post;

import com.tungong.socialnetwork.infrastructure.payload.dto.post.ImagePostDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImagePostResponse {
    List<ImagePostDto> images;
}
