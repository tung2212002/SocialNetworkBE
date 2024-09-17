package com.tungong.socialnetwork.application.port.output.auth;

import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtPort {
    Boolean isValidToken(String token, String email, DeviceInfoDto device);

    Boolean isValidRefreshToken(String token, DeviceInfoDto device);

    String generateToken(User user, DeviceInfoDto device);


    String generateRefreshToken(User user, DeviceInfoDto device);


    boolean isTokenValid(String token, UserDetails userDetails);


    String extractEmail(String token);

    String extractFingerprinting(String token);

    boolean isValidJwtFormat(String token);
}