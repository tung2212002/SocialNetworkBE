package com.tungong.socialnetwork.application.port.output.auth;


import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.adapter.input.sercurity.service.UserDetailsImpl;
import com.tungong.socialnetwork.infrastructure.payload.dto.TokenDto;
import org.antlr.v4.runtime.Token;
import org.springframework.data.util.Pair;

import java.util.Map;
import java.util.Set;

public interface AuthPort {
    User findByEmail(String input);

    User saveUser(User userEntity);

    Boolean existsUserByUserEmail(String userEmail);

    void changePassword(String newPassword, Long id);

    Token findByToken(String jwt, String email);

    void deleteUserByEmail(String email);

    User getUserById(Long id);

    User getUserByIdOrDefault(Long id);

    User getUserAuth();

    User getUserAuthOrDefaultVirtual();

    UserDetailsImpl getUserDetails(User user);

    Pair<UserDetailsImpl, String> refreshToken(String refreshToken, String fingerprinting);

    void saveRefreshTokenInRedis(String token, String fingerprinting, UserDetailsImpl userDetails);

    void saveAllAccessTokenInRedis(String userEmail, Set<Map<String, TokenDto>> tokenEntities);

    void saveAllAccessTokenInRedis(UserDetailsImpl userDetails, Set<Map<String, TokenDto>> tokenEntities);
}
