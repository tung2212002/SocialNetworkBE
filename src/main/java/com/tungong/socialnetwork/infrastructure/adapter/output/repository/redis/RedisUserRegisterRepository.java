package com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis;

import com.tungong.socialnetwork.infrastructure.payload.dto.redis.UserRegisterDataDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserDto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisUserRegisterRepository extends RedisRepository<String, UserRegisterDataDto> {
    private static final String KEY = "USER_REGISTER_";

    private static final Integer EXPIRE_TIME = 60 * 5;

    public RedisUserRegisterRepository(@Qualifier("userRegisterRedisTemplate") RedisTemplate<String, UserRegisterDataDto> redisTemplate) {
        super(redisTemplate, KEY, EXPIRE_TIME);
    }
}
