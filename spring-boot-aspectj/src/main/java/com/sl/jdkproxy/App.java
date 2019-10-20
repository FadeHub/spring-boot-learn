package com.sl.jdkproxy;

import com.sl.staticproxy.UserDao;
import com.sl.staticproxy.UserDaoImpl;

/**
 * @author shuliangzhao
 * @Title: App
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/19 17:22
 */
public class App {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        UserDao proxyInstance = (UserDao) new ProxyFactory(userDao).getProxyInstance();

        System.out.println(proxyInstance.getClass());

        // 执行方法   【代理对象】
        proxyInstance.delete();
    }
}
