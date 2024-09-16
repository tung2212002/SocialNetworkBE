package com.tungong.socialnetwork.application.port.output.user;

import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.user.SearchUserRequest;

import java.util.List;

public interface SearchPort {
    List<Long> searchUser(SearchUserRequest searchUserRequest, Long userId);

    List<Long> searchFriend(String keyword, Long userId, PaginationRequest paginationRequest);
}
