package com.zl.common.service;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

/**
 * redis 连接服务
 * @author zhongliang
 */
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Map<String, Object> getEntries(String key){
        BoundHashOperations<String, String, Object> bound = redisTemplate.boundHashOps(key);
        return bound.entries();
    }

    @SuppressWarnings(value={"unchecked", "rawtypes"})
    public void putAll(String key, Map map){
        BoundHashOperations<String, String, Object> bound = redisTemplate.boundHashOps(key);
        bound.putAll(map);
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }
}
