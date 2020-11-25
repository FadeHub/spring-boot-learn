package com.sl;

/**
 * @author shuliangzhao
 * @Title: Car
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/11/21 11:08
 */
public class Car {

    private String color;

    private String brand;

    public Car(String color, String brand) {
        this.color = color;
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
