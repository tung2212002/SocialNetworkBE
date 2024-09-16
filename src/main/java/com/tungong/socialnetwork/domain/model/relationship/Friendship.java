package com.tungong.socialnetwork.domain.model.relationship;

import com.tungong.socialnetwork.domain.model.enums.EFriendshipStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Friendship {
    Long id;

    Long userInitiatorId;

    Long userReceiverId;

    EFriendshipStatus status;

    Instant createdAt;
}
