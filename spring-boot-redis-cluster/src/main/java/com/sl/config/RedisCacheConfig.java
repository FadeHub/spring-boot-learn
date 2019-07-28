package com.sl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: RedisCacheConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/28 18:25
 */
@Configuration
public class RedisCacheConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisCacheManager redisCacheManager() {
        Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .prefixKeysWith("zhao:")
                .disableCachingNullValues()
                .entryTtl(Duration.ofMinutes(30));
        configurationMap.put("c1",redisCacheConfiguration);
        RedisCacheWriter cacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        RedisCacheManager redisCacheManager = new RedisCacheManager(cacheWriter,RedisCacheConfiguration.defaultCacheConfig(),configurationMap);
        return redisCacheManager;
    }
}
