package com.sl.entity;

/**
 * @author shuliangzhao
 * @Title: Student
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/7 17:09
 */
public class Student {

    private String name;

    private String age;

    private String idCar;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
