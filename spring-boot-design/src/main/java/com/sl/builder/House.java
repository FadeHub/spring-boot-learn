package com.sl.builder;

/**
 * 建造者模式
 * @author shuliangzhao
 * @Title: House
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/19 22:10
 */
public class House {

    private String baise;

    private String wall;

    private String roofed;

    public String getBaise() {
        return baise;
    }

    public void setBaise(String baise) {
        this.baise = baise;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
