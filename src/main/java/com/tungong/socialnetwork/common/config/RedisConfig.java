package com.tungong.socialnetwork.common.config;

import com.tungong.socialnetwork.domain.model.user.Device;
import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.TokenDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.redis.UserRegisterDataDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(host, port);
    }

    @Bean
    @Primary
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public RedisTemplate<String, String> customStringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return createRedisTemplate(redisConnectionFactory, String.class);
    }

    @Bean
    public RedisTemplate<String, TokenDto> tokenRedisTemplate(RedisConnectionFactory redisConnectionFactory)  {
        return createRedisTemplate(redisConnectionFactory, TokenDto.class);
    }

    @Bean
    public RedisTemplate<String, UserDto> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return createRedisTemplate(redisConnectionFactory, UserDto.class);
    }

    @Bean
    public RedisTemplate<String, UserRegisterDataDto> userRegisterRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return createRedisTemplate(redisConnectionFactory, UserRegisterDataDto.class);
    }

    @Bean
    public RedisTemplate<String, DeviceInfoDto> deviceRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return createRedisTemplate(redisConnectionFactory, DeviceInfoDto.class);
    }


    private <T> RedisTemplate<String, T> createRedisTemplate(RedisConnectionFactory redisConnectionFactory, Class<T> classType) {
        RedisTemplate<String, T> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(classType));
        return template;
    }
}
