package com.sl.beanprocessor;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author shuliangzhao
 * @Title: User
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/22 19:47
 */
public class User implements InitializingBean, DisposableBean {

    public User() {
        System.out.println("实例化User构造方法...");
    }

    public void initUser() {
        System.out.println("User初始化方法initUser...");
    }

    public void destroyUser() {
        System.out.println("User销毁方法destroyUser...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用实现DisposableBean的destroy方法....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用实现InitializingBean的afterPropertiesSet方法......");
    }
}
