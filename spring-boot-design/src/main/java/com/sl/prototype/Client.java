package com.sl.prototype;

/**
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/18 21:00
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("山羊",1);
        Sheep sheep1 = (Sheep) sheep.clone();

        System.out.println("sheep：" + sheep+ "，hashCode：" + sheep.hashCode());
        System.out.println("sheep1：" + sheep1+ "，hashCode：" + sheep1.hashCode());

    }
}
