package com.sl.chapter01.usedesign;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author shuliangzhao
 * @Title: Car
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/29 22:22
 */
public abstract class Car {

    private ChargeCar chargeCar;

    private RefuelCar refuelCar;

    public void setChargeCar(ChargeCar chargeCar) {
        this.chargeCar = chargeCar;
    }

    public void setRefuelCar(RefuelCar refuelCar) {
        this.refuelCar = refuelCar;
    }

    public abstract void brand();

    public void performRefuel() {
        refuelCar.refuel();
    }

    public void performCharge() {
        chargeCar.charge();
    }

    public void carDoor() {

    }

    public void wheelHub() {

    }

    public void color() {

    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd");
        Calendar instance = Calendar.getInstance();  //当前时间为2020-12-30
        instance.add(Calendar.DATE,-4);
        System.out.println("yyyy-MM-dd： " + sdf.format(instance.getTime()));
        System.out.println("YYYY-MM-dd： " + sdf1.format(instance.getTime()));
        System.out.println("=========我是分割线=========");
        Calendar instance1 = Calendar.getInstance();
        instance1.add(Calendar.DATE,-3); //当前时间为2020-12-30
        System.out.println("yyyy-MM-dd = " + sdf.format(instance1.getTime()));
        System.out.println("YYYY-MM-dd = " + sdf1.format(instance1.getTime()));
    }

}
