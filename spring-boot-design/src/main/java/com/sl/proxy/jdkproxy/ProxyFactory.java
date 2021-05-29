package com.sl.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shuliangzhao
 * @Title: ProxyFactory
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/29 13:31
 */
public class ProxyFactory {

    //代理对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object  getInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("教学之前备课");
                        Object invoke = method.invoke(target, args);
                        return invoke;
                    }
                });
    }
}
