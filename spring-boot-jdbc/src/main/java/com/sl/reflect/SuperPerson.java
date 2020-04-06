package com.sl.reflect;

/**
 * @author shuliangzhao
 * @Title: SuperPerson
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/4/6 9:54
 */
public class SuperPerson<T> {

    private String car;

    public SuperPerson() {
    }

    public SuperPerson(String car) {
        this.car = car;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
