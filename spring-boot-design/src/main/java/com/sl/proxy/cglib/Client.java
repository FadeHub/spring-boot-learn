package com.sl.proxy.cglib;

/**
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/29 15:47
 */
public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new TeacherDao());
        TeacherDao instance = (TeacherDao) proxyFactory.getInstance();
        instance.teach();
    }
}
