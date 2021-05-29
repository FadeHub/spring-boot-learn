package com.sl.proxy.jdkproxy;

/**
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/29 13:34
 */
public class Client {

    public static void main(String[] args) {
        ITeacherDao target = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        ITeacherDao instance =(ITeacherDao) proxyFactory.getInstance();
        instance.teach();
    }
}
