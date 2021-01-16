package com.sl.chapter02;

import java.util.concurrent.TimeUnit;

/**
 * @author shuliangzhao
 * @Title: CacheService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/16 15:58
 */
public interface CacheService {

    String get(String key);

    void set(String key,String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
