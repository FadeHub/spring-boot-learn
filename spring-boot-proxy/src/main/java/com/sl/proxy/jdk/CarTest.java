package com.sl.proxy.jdk;

import java.lang.reflect.InvocationHandler;

/**
 * @author shuliangzhao
 * @Title: CarTest
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/26 16:28
 */
public class CarTest {

    public static void main(String[] args) {
        InvocationHandler handler = new CarHandler(new AudiCar());
        Car car = (Car) ProxyUtil.invokeProxy(AudiCar.class, handler);
        car.run();
    }
}
