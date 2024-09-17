package com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis;

import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDeviceRepository extends RedisRepository<String, DeviceInfoDto>{
    private static final String KEY = "DEVICE_";

    private static final Integer EXPIRE_TIME = 60 ;

    public RedisDeviceRepository(@Qualifier("deviceRedisTemplate") RedisTemplate<String, DeviceInfoDto> redisTemplate) {
        super(redisTemplate, KEY, EXPIRE_TIME);
    }
}
