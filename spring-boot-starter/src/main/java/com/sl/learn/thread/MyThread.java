package com.sl.learn.thread;

/**
 * @author shuliangzhao
 * @Title: MyThread
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/4/12 16:14
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0 ;i < 50;i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
    }
    public static void main(String[] args) {
        for (int i = 0;i<50;i++) {
            //调用Thread类的currentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 10) {
                new MyThread().start();
                new MyThread().start(); 
            }
        }
    }
}
