package com.sl.proxy.cglib;

/**
 * @author shuliangzhao
 * @Title: CglibTest
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/26 18:36
 */
public class CglibTest {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Computer computer = (Computer) cglibProxy.invokePorxy(Computer.class);
        computer.lenovo();
    }
}
