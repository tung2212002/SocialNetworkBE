package com.tungong.socialnetwork.application.port.output.redis;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface RedisPort<K, V> {
    void save(K key, V value);

    V getFullKey(K key);

    V get(K key);
    void delete(K key);

    void deleteFullKey(K key);

    void createOrUpdate(K key, V value);
    boolean exists(K key);
    boolean createWithTTL(K key, V value, long ttl, TimeUnit timeUnit);

    boolean createWithTTL(K key, V value);

    boolean update(K key, V value);

    boolean updateFullKey(K key, V value);

    List<K> getAllKeyByPattern(String pattern);
    void deleteAllByPattern(String pattern);
    List<K> getAllKeyByPrefix(String prefix);
    void deleteAllByPrefix(String prefix);
    List<K> getAllKeyBySuffix(String suffix);
    void deleteBySuffix(String suffix);
    List<K> getAllKeyByBody(String body);
    void deleteByBody(String body);
}
