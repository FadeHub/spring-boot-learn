package com.sl.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author shuliangzhao
 * @Title: UserDaoInvocationHandler
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/19 17:14
 */
public class UserDaoInvocationHandler implements InvocationHandler {

    private Object target;

    public UserDaoInvocationHandler(Object target) {
          this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" +method.getName() + "方法");
        Object invoke = method.invoke(target, args);
        return invoke;
    }
}
