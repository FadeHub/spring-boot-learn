package com.sl.chapter02;

import com.sl.chapter02.factory.JDKProxy;
import com.sl.chapter02.factory.impl.EGMCacheAdaper;
import com.sl.chapter02.impl.CacheServiceImpl;
import com.sl.chapter02.matter.EGM;

/**
 * @author shuliangzhao
 * @Title: AbstractMain
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/16 16:46
 */
public class AbstractMain {

    public static void main(String[] args) {
        CacheService cacheService = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdaper());
        cacheService.set("test","zhangsan");
        System.out.println("test".getClass());
        System.out.println(cacheService.get("test"));
    }
}
