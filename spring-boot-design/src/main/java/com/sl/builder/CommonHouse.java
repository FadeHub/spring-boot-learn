package com.sl.builder;

/**
 * @author shuliangzhao
 * @Title: CommonHouse
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/19 22:13
 */
public class CommonHouse extends AbstractHouseBuilder{
    @Override
    protected String builderBaise() {
        System.out.println(" 普通房子地基2米");
        return "普通房子地基2米";
    }

    @Override
    protected String builderWall() {
        System.out.println(" 普通房子水泥墙");
        return "普通房子水泥墙";
    }

    @Override
    protected String builderRoofed() {
        System.out.println(" 普通房子房顶");
        return "普通房子房顶";
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
