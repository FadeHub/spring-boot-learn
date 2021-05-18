package com.sl.prototype;

/**
 * 原型模式其实就是clone对象
 * 属于浅拷贝
 * 浅拷贝只能拷贝基本属性，不能拷贝引用或list对象、数组
 * @author shuliangzhao
 * @Title: Sheep
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/18 20:59
 */
public class Sheep implements Cloneable{

    private String name;

    private int age;

    public Sheep() {
    }

    public Sheep(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep sheep = (Sheep)super.clone();
        return sheep;
    }
}
