package com.tungong.socialnetwork.application.service;


import com.tungong.socialnetwork.application.port.input.user.SearchPortInput;
import com.tungong.socialnetwork.infrastructure.payload.dto.relationship.FriendShipUserDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserBasicDto;
import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.user.SearchUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService implements SearchPortInput {
    @Override
    public List<FriendShipUserDto> searchUser(SearchUserRequest searchUserRequest) {
        return null;
    }

    @Override
    public List<UserBasicDto> searchFriend(String keyword, PaginationRequest paginationRequest) {
        return null;
    }
}
