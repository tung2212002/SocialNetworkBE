package com.tungong.socialnetwork.infrastructure.payload.dto.post;

import com.tungong.socialnetwork.infrastructure.payload.dto.ImageDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostBasicDto {
    Long id;

    String status;

    List<ImageDto> images;
}
