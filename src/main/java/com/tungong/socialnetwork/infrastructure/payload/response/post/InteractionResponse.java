package com.tungong.socialnetwork.infrastructure.payload.response.post;

import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserBasicDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InteractionResponse {
    Long roleId;

    String role;

    UserBasicDto user;

    EReactionType type;

    String content;

    String image;

    Instant createdAt;
}
