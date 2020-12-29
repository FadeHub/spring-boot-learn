package com.sl.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author shuliangzhao
 * @Title: ProxyUtil
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/26 16:26
 */
public class ProxyUtil {

    public static Object invokeProxy(Class clz, InvocationHandler handler) {
       return Proxy.newProxyInstance(clz.getClassLoader(),clz.getInterfaces(),handler);
    }
}
