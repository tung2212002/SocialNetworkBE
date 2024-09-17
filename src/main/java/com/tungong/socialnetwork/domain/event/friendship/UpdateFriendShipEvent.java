package com.tungong.socialnetwork.domain.event.friendship;

import com.tungong.socialnetwork.domain.model.enums.EFriendshipStatus;
import com.tungong.socialnetwork.domain.model.relationship.Friendship;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateFriendShipEvent {
    private Friendship friendship;

    private EFriendshipStatus status;

    private EFriendshipStatus previousStatus;
}
