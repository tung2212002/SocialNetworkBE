package com.tungong.socialnetwork.infrastructure.payload.dto.relationship;

import com.tungong.socialnetwork.domain.model.enums.EFriendshipStatus;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserBasicDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FriendShipUserDto {
    UserBasicDto user;

    EFriendshipStatus status;

    Long mutualFriends;
}
