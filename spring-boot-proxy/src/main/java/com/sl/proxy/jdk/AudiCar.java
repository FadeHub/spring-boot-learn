package com.sl.proxy.jdk;

/**
 * @author shuliangzhao
 * @Title: AudiCar
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/26 16:23
 */
public class AudiCar implements Car {
    @Override
    public void run() {
        System.out.println("速度70！");
    }
}
