package com.tungong.socialnetwork.infrastructure.adapter.input;

import com.tungong.socialnetwork.application.port.input.user.SearchPortInput;
import com.tungong.socialnetwork.infrastructure.payload.dto.relationship.FriendShipUserDto;
import com.tungong.socialnetwork.infrastructure.payload.request.user.SearchUserRequest;
import com.tungong.socialnetwork.infrastructure.payload.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchController {
    SearchPortInput searchPortInput;

    @GetMapping("")
    public ApiResponse<List<FriendShipUserDto>> searchUser(@Valid @ModelAttribute SearchUserRequest searchUserRequest) {
        return ApiResponse.<List<FriendShipUserDto>>builder()
                .result(searchPortInput.searchUser(searchUserRequest))
                .build();
    }
}
