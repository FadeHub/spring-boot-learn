package com.sl.chapter02.factory;

import com.sl.chapter02.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author shuliangzhao
 * @Title: JDKInvocationHandler
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/16 16:18
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdaper iCacheAdaper;

    public JDKInvocationHandler(ICacheAdaper iCacheAdaper) {
          this.iCacheAdaper = iCacheAdaper;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdaper.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(iCacheAdaper,args);
    }
}
