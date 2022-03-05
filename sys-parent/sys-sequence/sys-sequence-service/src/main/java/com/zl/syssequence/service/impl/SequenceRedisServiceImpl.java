package com.zl.syssequence.service.impl;

import com.zl.common.error.TradeCodeDict;
import com.zl.common.exception.ZlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author zhongliang
 */
@Service("SequenceRedisServiceImpl")
public class SequenceRedisServiceImpl extends AbstractSequenceService {

    @Autowired
    public RedisTemplate redisTemplate;

    @Override
    @SuppressWarnings("unchecked")
    public Long getSeqence(String name) {
        Object o = redisTemplate.boundValueOps(name).get();
        if(o == null){
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            redisTemplate.opsForValue().set(name,"0");
            return 0L;
        }else{
            long l = 0;
            try {
                l = Long.parseLong(o.toString());
            } catch (NumberFormatException e) {
                throw new ZlException(TradeCodeDict.FAILED_FORMAT_CODE);
            }
            return l;
        }
    }

    @Override
    public Long resetSeq(String name) {
        redisTemplate.boundValueOps(name).set("0");
        return 0L;
    }

    @Override
    public Integer updateSeq(String name) {
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(name);
        redisTemplate.opsForValue().increment(name, 1);
        return 1;
    }
}
