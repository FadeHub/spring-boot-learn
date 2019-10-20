package com.sl.cglibproxy;

/**
 * @author shuliangzhao
 * @Title: App
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/19 17:34
 */
public class App {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        UserDao proxyInstance = (UserDao) new ProxyFactory(userDao).getProxyInstance();
        proxyInstance.delete();
    }
}
