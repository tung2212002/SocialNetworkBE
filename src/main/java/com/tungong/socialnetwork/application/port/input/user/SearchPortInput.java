package com.tungong.socialnetwork.application.port.input.user;

import com.tungong.socialnetwork.infrastructure.payload.dto.relationship.FriendShipUserDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserBasicDto;
import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.user.SearchUserRequest;

import java.util.List;

public interface SearchPortInput {
    List<FriendShipUserDto> searchUser(SearchUserRequest searchUserRequest);

    List<UserBasicDto> searchFriend(String keyword, PaginationRequest paginationRequest);
}
