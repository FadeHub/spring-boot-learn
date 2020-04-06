package com.sl.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shuliangzhao
 * @Title: ProxyHandler
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/4/6 11:44
 */
public class ProxyHandler implements InvocationHandler {

    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        Object invoke = method.invoke(target, args);
        System.out.println("After invoke " + method.getName());
        return invoke;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        ProxyHandler proxyHandler = new ProxyHandler(cat);
        Anmail proxy = (Anmail)(Proxy.newProxyInstance(cat.getClass().getClassLoader(), cat.getClass().getInterfaces(), proxyHandler));
        proxy.name();
    }
}
