package com.tungong.socialnetwork.application.port.output.relationship;

import com.tungong.socialnetwork.domain.model.relationship.Friendship;
import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;

import java.util.List;

public interface BlockPort {
    Friendship add(Long userInitiatorId, Long userReceiveId);

    Friendship get(Long userInitiatorId, Long userReceiveId);

    void delete(Long friendShipId);

    List<Friendship> getList(PaginationRequest paginationRequest);

    Boolean isBlock(Long fistUserId, Long secondUserId);
}