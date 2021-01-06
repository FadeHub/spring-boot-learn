package com.sl.chapter01.nodesign;

/**
 * @author shuliangzhao
 * @Title: ToyCar
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/29 22:08
 */
public class ToyTruckCar implements Car {
    @Override
    public void carDoor() {
        System.out.println("I have two carDoor!");
    }

    @Override
    public void wheelHub() {
        System.out.println("I have four wheelHub!");
    }

    @Override
    public void color() {
        System.out.println("I'm red!");
    }

    @Override
    public void refuel() {
        //不能加油
    }

    @Override
    public void charge() {
        //不能充电
    }
}
