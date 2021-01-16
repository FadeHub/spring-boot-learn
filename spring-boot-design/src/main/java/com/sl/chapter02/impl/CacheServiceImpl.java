package com.sl.chapter02.impl;

import com.sl.chapter02.CacheService;
import com.sl.chapter02.util.RedisUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author shuliangzhao
 * @Title: CacheServiceImpl
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/16 16:08
 */
public class CacheServiceImpl implements CacheService {

    private RedisUtil redisUtil = new RedisUtil();

    @Override
    public String get(String key) {
        return redisUtil.get(key);
    }

    @Override
    public void set(String key, String value) {
         redisUtil.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
          redisUtil.set(key,value);
    }

    @Override
    public void del(String key) {
          redisUtil.del(key);
    }
}
