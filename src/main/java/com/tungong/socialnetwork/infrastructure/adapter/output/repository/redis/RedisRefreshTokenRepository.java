package com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis;

import com.tungong.socialnetwork.infrastructure.payload.dto.TokenDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRefreshTokenRepository extends RedisRepository<String, TokenDto> {
    private static final String KEY = "REFRESH_TOKEN";

    public RedisRefreshTokenRepository(@Qualifier("tokenRedisTemplate") RedisTemplate<String, TokenDto> redisTemplate) {
        super(redisTemplate, KEY);
    }
}
