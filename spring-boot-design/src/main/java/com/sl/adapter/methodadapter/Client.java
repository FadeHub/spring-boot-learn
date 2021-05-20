package com.sl.adapter.methodadapter;

/**
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/20 22:21
 */
public class Client {

    public static void main(String[] args) {
        AbstractCar aodi = new AbstractCar() {
            @Override
            public void engine() {
                System.out.println("奥迪发动机");
            }
        };
        aodi.engine();
    }
}
