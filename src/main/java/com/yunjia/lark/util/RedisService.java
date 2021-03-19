package com.yunjia.lark.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import java.util.List;

/**
 * @Author myou
 * @Date 2021/3/19  5:40 下午
 */
public class RedisService {
    public static <T, K> T executeScript(RedisTemplate redisTemplate, String scriptPath, List<String> keys, K k, String... args) {
        DefaultRedisScript<K> redisScript = new DefaultRedisScript();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource(scriptPath)));
        redisScript.setResultType((Class<K>) k);
        Object execute = redisTemplate.execute(redisScript, keys, args);
        if (execute.getClass().isAssignableFrom((Class<?>) k))
            return (T) execute;
        return null;
    }
}
