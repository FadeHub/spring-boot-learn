package com.sl.entity;

/**
 * @author shuliangzhao
 * @Title: Person
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/2/1 18:44
 */
public class Person {

    private String name;
    private int age;
    private String IdCard;

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

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }
}
