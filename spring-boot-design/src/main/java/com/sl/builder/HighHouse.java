package com.sl.builder;

/**
 * @author shuliangzhao
 * @Title: HighHouse
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/19 22:17
 */
public class HighHouse extends AbstractHouseBuilder{
    @Override
    protected String builderBaise() {
        System.out.println(" 高楼地基20米");
        return null;
    }

    @Override
    protected String builderWall() {
        System.out.println(" 高楼墙是玻璃");
        return "高楼墙是玻璃";
    }

    @Override
    protected String builderRoofed() {
        System.out.println(" 高楼房顶");
        return "高楼房顶";
    }

    @Override
    protected House build() {
        House house = new House();
        house.setBaise(builderBaise());
        house.setWall(builderWall());
        house.setRoofed(builderRoofed());
        return house;
    }
}
