package com.sl.staticproxy;

/**
 * @author shuliangzhao
 * @Title: App
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/19 17:06
 */
public class App {

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.delete();
    }
}
