package com.tungong.socialnetwork.infrastructure.payload.response.post;

import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import com.tungong.socialnetwork.infrastructure.payload.dto.ImageDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserBasicDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponse {
    Long id;

    String content;

    Instant createdAt;

    Instant updatedAt;

    String status;

    List<UserBasicDto> tagUsers;

    List<ImageDto> images;

    Long reactionsQuantity;

    Long commentsQuantity;

    UserBasicDto user;

    EReactionType type;
}
