package com.sl.builder;

import java.util.Random;

/**
 * @author shuliangzhao
 * @Title: Cliect
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/19 22:20
 */
public class Client {

    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        House house = new HouseDiector(commonHouse).buildDiector();
        System.out.println(house.getBaise());

        Random random = new Random();
        int i = random.nextInt(10);
        System.out.println(i);
        String s = String.valueOf(i);
        System.out.println(s);
    }
}
