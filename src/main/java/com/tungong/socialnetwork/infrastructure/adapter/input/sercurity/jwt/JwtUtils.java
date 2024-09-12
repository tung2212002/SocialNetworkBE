package com.tungong.socialnetwork.infrastructure.adapter.input.sercurity.jwt;

import com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis.RedisAccessTokenRepository;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis.RedisRefreshTokenRepository;
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
public class JwtUtils {
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

    public Boolean isValidToken(String token) {
        return redisAccessTokenRepository.get(token) != null || redisRefreshTokenRepository.get(token) != null;
    }

    public String generateToken(UserDetails userDetails, String fingerprinting) {
        Map<String, Object> claims = Map.of("fingerprinting", fingerprinting);
        return buildToken(claims, userDetails, expiration);

    }

    public String generateRefreshToken(UserDetails userDetails, String fingerprinting) {
        Map<String, Object> claims = Map.of("fingerprinting", fingerprinting);
        return buildToken(claims, userDetails, refreshExpiration);
    }

    private String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            long expiration
    ) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(generateSecretKey())
                .compact();
    }

    public String extractFingerprinting(String token) {
        return extractClaim(token, claims -> claims.get("fingerprinting", String.class));
    }
}
