package com.sl.chapter02.factory;

import java.util.concurrent.TimeUnit;

/**
 * @author shuliangzhao
 * @Title: ICacheAdaper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/16 16:10
 */
public interface ICacheAdaper {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
