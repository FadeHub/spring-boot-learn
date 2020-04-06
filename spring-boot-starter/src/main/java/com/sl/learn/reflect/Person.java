package com.sl.learn.reflect;

import org.springframework.scheduling.annotation.Async;

/**
 * @author shuliangzhao
 * @Title: Person
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/4/5 16:05
 */
@Async
public class Person<T> extends SuperPerson{

    private String name;

    private int age;

    private String address;

    public Person() {

    }

    private  Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private void setCardId(String id) {
        System.out.println(id);
    }
}
