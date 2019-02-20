package com.supi.mh.restful.app.service.impl;

import com.sun.xml.internal.ws.api.model.CheckedException;
import com.supi.mh.restful.app.service.RedisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.oops.CheckedExceptionElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by supiccc on 2018-10-12 15:46
 */
@Service
public class RedisServiceImpl implements RedisService {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void set(String key, String value, long time) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        vo.set(key, value, time, TimeUnit.MINUTES);
    }

    @Override
    public Object get(String key) {
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    @Override
    public boolean del(String key) {
        return redisTemplate.delete(key);
    }
}
