package com.sl.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author shuliangzhao
 * @Title: ProxyFactory
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/19 17:19
 */
public class ProxyFactory {

    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new UserDaoInvocationHandler(target));
    }
}
