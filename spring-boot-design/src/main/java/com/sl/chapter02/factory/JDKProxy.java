package com.sl.chapter02.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author shuliangzhao
 * @Title: JDKProxy
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/16 16:43
 */
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdaper cacheAdapter) {
        InvocationHandler invocationHandler = new JDKInvocationHandler(cacheAdapter);
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(),interfaceClass.getInterfaces(),invocationHandler);
    }
}
