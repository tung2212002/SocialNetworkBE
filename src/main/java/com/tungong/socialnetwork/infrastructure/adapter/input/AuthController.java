package com.tungong.socialnetwork.infrastructure.adapter.input;

import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserBasicDto;
import com.tungong.socialnetwork.infrastructure.payload.response.ApiResponse;
import com.tungong.socialnetwork.infrastructure.payload.response.AuthResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthController {

    @GetMapping("/profile")
    public ApiResponse<Object> profile() {
        AuthResponse authResponse = AuthResponse.builder()
                .accessToken("accessToken")
                .refreshToken("refreshToken")
                .user(UserBasicDto.builder()
                        .id(1L)
                        .email("email")
                        .firstName("firstName")
                        .lastName("lastName")
                        .build())
                .tokenType("tokenType")
                .build();
        return ApiResponse.builder()
                .result(authResponse)
                .build();
    }

}
