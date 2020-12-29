package com.sl.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author shuliangzhao
 * @Title: CarHandler
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/26 16:23
 */
public class CarHandler implements InvocationHandler {

    private Object object;

    public CarHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName()+ ",args" + args);
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }
}
