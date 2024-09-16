package com.tungong.socialnetwork.application.port.input.relationship;

import com.tungong.socialnetwork.infrastructure.payload.dto.relationship.FriendShipUserDto;
import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.relationship.AcceptFriendRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.relationship.SetRequestFriendRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.relationship.UnFriendRequest;
import com.tungong.socialnetwork.infrastructure.payload.response.relationship.RelationshipResponse;

import java.util.List;

public interface FriendShipPortInput {

    RelationshipResponse getListFriend(PaginationRequest paginationRequest);

    List<FriendShipUserDto> getListSuggestFriend();

    FriendShipUserDto createRequestFriend(SetRequestFriendRequest setRequestFriendRequest);

    FriendShipUserDto updateStateFriend(SetRequestFriendRequest setRequestFriendRequest);

    FriendShipUserDto acceptFriendRequest(AcceptFriendRequest acceptFriendRequest);

    FriendShipUserDto unFriendRequest(UnFriendRequest unFriendRequest);

}