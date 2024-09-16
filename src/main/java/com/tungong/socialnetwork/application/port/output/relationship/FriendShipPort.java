package com.tungong.socialnetwork.application.port.output.relationship;


import com.tungong.socialnetwork.domain.model.enums.EFriendshipStatus;
import com.tungong.socialnetwork.domain.model.relationship.Friendship;
import com.tungong.socialnetwork.infrastructure.payload.request.relationship.GetFriendShipRequest;

import java.util.LinkedList;
import java.util.List;

public interface FriendShipPort {
    Friendship add(Long userInitiatorId, Long userReceiveId, EFriendshipStatus status);

    Friendship setRequest(Long friendShipId, EFriendshipStatus status);

    Friendship get(Long userInitiatorId, Long userReceiveId);

    void deleteByFriendshipId(Long friendShipId);

    List<Friendship> getList(GetFriendShipRequest getFriendShipRequest);

    Long countByUserReceiveIdAndFriendshipStatus(GetFriendShipRequest getFriendShipRequest);

    Long countByUserInitiatorIdAndFriendshipStatus(Long userInitiatorId, EFriendshipStatus status);

    Boolean isFriend(Long fistUserId, Long secondUserId);

    List<Long> getListSuggest(Long userId);

    int getMutualFriend(Long userInitiatorId, Long userReceiveId);

    int getMutualFriendNeo(Long firstUser, Long secondUser);

    LinkedList<Long> getListBlockBoth(Long userId);
}