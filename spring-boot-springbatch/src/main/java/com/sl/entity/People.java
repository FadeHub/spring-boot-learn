package com.sl.entity;

/**
 * @author shuliangzhao
 * @Title: User
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/7 16:53
 */
public class People {

    private String name;

    private String age;

    private String adress;

    public People() {
    }

    public People(String name, String age, String adress, String idCard) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.idCard = idCard;
    }

    private String idCard;



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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", adress='" + adress + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
