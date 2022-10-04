package com.sl.cache;

import com.sl.config.MyBatisRedisSpringContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @package: com.sl.cache
 * @author: shuliangzhao
 * @description:
 * @date 2022/10/4 15:58
 */
@Slf4j
public class MybatisRedisCache implements Cache {

    private RedisTemplate<String,Object> redisTemplate;

    private ReadWriteLock  readWriteLock = new ReentrantReadWriteLock();

    private String id;

    public MybatisRedisCache(String id) {
        this.id = id;
        if (redisTemplate == null) {
            redisTemplate = MyBatisRedisSpringContext.getBean("redisTemplate");
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        if (Objects.nonNull(o1)) {
            redisTemplate.opsForHash().put(id,o.toString(),o1);
            log.info("mybatis缓存key：{}，value：{}",o,o1);
        }
    }

    @Override
    public Object getObject(Object o) {
        if (Objects.nonNull(o)) {
            Object o1 = redisTemplate.opsForHash().get(id, o.toString());
            log.info("mybatis读取缓存，key：{}，value：{}",o,o1);
            return o1;
        }
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        if (Objects.nonNull(o)) {
            redisTemplate.opsForHash().delete(id,o.toString());
        }
        return null;
    }

    @Override
    public void clear() {
        redisTemplate.execute((RedisCallback<Void>) connection -> {
            //通过connection对象执行清空操作
            connection.flushDb();
            return null;
        });
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
