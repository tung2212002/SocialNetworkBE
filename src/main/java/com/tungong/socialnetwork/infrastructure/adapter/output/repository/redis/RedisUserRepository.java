package com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis;

import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisUserRepository extends RedisRepository<String, UserDto>{
    private static final String KEY = "USER";

    private static final Integer EXPIRE_TIME = 60 * 60 * 24 * 7;

    public RedisUserRepository(@Qualifier("userRedisTemplate") RedisTemplate<String, UserDto> redisTemplate) {
        super(redisTemplate, KEY, EXPIRE_TIME);
    }
}
