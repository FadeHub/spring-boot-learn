package com.sl.dto;

/**
 * @author shuliangzhao
 * @Title: Perple
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/23 15:59
 */
public class Perple {

    private String userName;
    private String age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static Perple builer() {
          return new Perple();
    }

    public Perple build() {
        return this;
    }

    public Perple userName(String userName) {
          this.userName=userName;
          return this;
    }
    public Perple age(String age) {
        this.age=age;
        return this;
    }

    public static void main(String[] args) {
        Perple age = Perple.builer().age("213").build();
        System.out.println(age.getAge());
    }
}
