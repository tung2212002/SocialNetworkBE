package com.tungong.socialnetwork.infrastructure.adapter.input.sercurity.jwt;

import com.tungong.socialnetwork.application.port.output.auth.JwtPort;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis.RedisAccessTokenRepository;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis.RedisRefreshTokenRepository;
import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.TokenDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class JwtUtils implements JwtPort {
    @Value("${jwt.secretKey}")
    String secretKey;

    @Value("${jwt.expiration}")
    int expiration;

    @Value("${jwt.refreshExpiration}")
    int refreshExpiration;

    final RedisRefreshTokenRepository redisRefreshTokenRepository;
    final RedisAccessTokenRepository redisAccessTokenRepository;

    private SecretKey generateSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(generateSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    @Override
    public Boolean isValidToken(String token, String email, DeviceInfoDto device) {
        TokenDto tokenDto = redisAccessTokenRepository.get(email + "_" + token);
        return tokenDto != null && tokenDto.getAgent().equals(device.getAgent()) && tokenDto.getIp().equals(device.getIp()) && tokenDto.getFingerprinting().equals(device.getFingerprinting());
    }

    @Override
    public Boolean isValidRefreshToken(String token, DeviceInfoDto device) {
        String email = extractEmail(token);
        if (email == null) return false;
        TokenDto tokenDto = redisRefreshTokenRepository.get(email + "_" + token);
        return tokenDto != null && tokenDto.getAgent().equals(device.getAgent()) && tokenDto.getIp().equals(device.getIp()) && tokenDto.getFingerprinting().equals(device.getFingerprinting());
    }

    @Override
    public String generateToken(User user, DeviceInfoDto device) {
        return buildToken(buildClaims(device), user, expiration);

    }


    @Override
    public String generateRefreshToken(User user, DeviceInfoDto device) {
        Map<String, Object> claims = buildClaims(device);
        return buildToken(claims, user, refreshExpiration);
    }

    private Map<String, Object> buildClaims(DeviceInfoDto device) {
        return Map.of("fingerprinting", device.getFingerprinting(), "agent", device.getAgent(), "ip", device.getIp());
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        return false;
    }


    private String buildToken(
            Map<String, Object> extraClaims,
            User user,
            long expiration
    ) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(generateSecretKey())
                .compact();
    }

    public String extractFingerprinting(String token) {
        return extractClaim(token, claims -> claims.get("fingerprinting", String.class));
    }

    @Override
    public boolean isValidJwtFormat(String token) {
        return false;
    }
}
