package com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis;

import com.tungong.socialnetwork.application.port.output.redis.RedisPort;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class RedisRepository<K, V> implements RedisPort<K, V> {
    private  RedisTemplate<K, V> redisTemplate;

    private  String keyPrefix;

    protected K getKey(K key) {
        return (K) (keyPrefix + "_" + key);
    }

    @Override
    public void save(K key, V value) {
        redisTemplate.opsForValue().set(getKey(key), value);
    }

    @Override
    public V get(K key) {
        return redisTemplate.opsForValue().get(getKey(key));
    }

    @Override
    public void delete(K key) {
        redisTemplate.delete(getKey(key));
    }

    @Override
    public void createOrUpdate(K key, V value) {
        redisTemplate.opsForValue().set(getKey(key), value);
    }

    @Override
    public boolean exists(K key) {
        Boolean result = redisTemplate.hasKey(getKey(key));
        return result != null && result;
    }

    @Override
    public boolean createWithTTL(K key, V value, long ttl, TimeUnit timeUnit) {
        Boolean result = redisTemplate.opsForValue().setIfAbsent(getKey(key), value, ttl, timeUnit);
        return result != null && result;
    }

    @Override
    public List<K> getAllKeyByPattern(String pattern) {
        Set<K> keys = redisTemplate.keys((K) pattern);
        return keys != null && !keys.isEmpty() ? new ArrayList<>(keys) : Collections.emptyList();
    }

    @Override
    public void deleteAllByPattern(String pattern) {
        getAllKeyByPattern(pattern).forEach(redisTemplate::delete);
    }

    @Override
    public List<K> getAllKeyByPrefix(String prefix) {
        return getAllKeyByPattern(getKey((K) prefix) + "*");
    }

    @Override
    public void deleteAllByPrefix(String prefix) {
        deleteAllByPattern(getKey((K) prefix) + "*");
    }

    @Override
    public List<K> getAllKeyBySuffix(String suffix) {
        return getAllKeyByPattern("*" + suffix);
    }

    @Override
    public void deleteBySuffix(String suffix) {
        deleteAllByPattern("*" + suffix);
    }

    @Override
    public List<K> getAllKeyByBody(String body) {
        return getAllKeyByPattern("*" + body + "*");
    }

    @Override
    public void deleteByBody(String body) {
        deleteAllByPattern("*" + body + "*");
    }
}
