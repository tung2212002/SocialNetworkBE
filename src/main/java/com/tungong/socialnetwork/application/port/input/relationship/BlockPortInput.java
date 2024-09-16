package com.tungong.socialnetwork.application.port.input.relationship;

import com.tungong.socialnetwork.infrastructure.payload.dto.relationship.FriendShipUserDto;
import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.relationship.BlockRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.relationship.UnBlockRequest;
import com.tungong.socialnetwork.infrastructure.payload.response.relationship.RelationshipResponse;

public interface BlockPortInput {
    RelationshipResponse getListBlock(PaginationRequest paginationRequest);

    FriendShipUserDto blockRequest(BlockRequest blockRequest);

    FriendShipUserDto unBlockRequest(UnBlockRequest unBlockRequest);
}