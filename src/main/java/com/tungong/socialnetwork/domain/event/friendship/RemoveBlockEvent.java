package com.tungong.socialnetwork.domain.event.friendship;

import com.tungong.socialnetwork.domain.model.relationship.Friendship;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoveBlockEvent {
    private Friendship friendShip;
}
