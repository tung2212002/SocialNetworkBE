package com.tungong.socialnetwork.infrastructure.payload.dto.post;

import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReactionCountDto {
    Long quantity;

    EReactionType type;
}
