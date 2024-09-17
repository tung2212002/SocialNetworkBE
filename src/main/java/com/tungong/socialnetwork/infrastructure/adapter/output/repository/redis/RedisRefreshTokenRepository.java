package com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis;

import com.tungong.socialnetwork.infrastructure.payload.dto.TokenDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRefreshTokenRepository extends RedisRepository<String, TokenDto> {
    private static final String KEY = "REFRESH_TOKEN";

    private static final Integer EXPIRE_TIME = 60 * 60 * 24 * 30;

    public RedisRefreshTokenRepository(@Qualifier("tokenRedisTemplate") RedisTemplate<String, TokenDto> redisTemplate) {
        super(redisTemplate, KEY, EXPIRE_TIME);
    }
}
