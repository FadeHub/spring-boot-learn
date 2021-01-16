package com.sl.chapter02.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author shuliangzhao
 * @Title: RedisUtil
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/16 16:05
 */
public class RedisUtil {

    private Map<String,String> map = new ConcurrentHashMap<>();

    public String get(String key) {
       return map.get(key);
    }

    public void set(String key,String value) {
        map.put(key,value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        map.put(key,value);
    }

    public void del(String key) {
        map.remove(key);
    }
}
