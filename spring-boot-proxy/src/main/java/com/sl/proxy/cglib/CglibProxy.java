package com.sl.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author shuliangzhao
 * @Title: CglibProxy
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/26 18:32
 */
public class CglibProxy implements MethodInterceptor {

    public Object invokePorxy(Class<?> clz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(o,objects);
    }
}
