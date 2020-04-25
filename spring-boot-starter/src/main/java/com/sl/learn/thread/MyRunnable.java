package com.sl.learn.thread;

/**
 * @author shuliangzhao
 * @Title: MyRunnable
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/4/12 16:31
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0 ;i < 50 ;i++) {
            System.out.println(Thread.currentThread().getName()+"：" +i);
        }
    }

    public static void main(String[] args) {
       /* for (int i = 0;i < 50;i++) {
            System.out.println(Thread.currentThread().getName() + "：" +i);
            if (i == 10) {
                MyRunnable myRunnable = new MyRunnable();
                new Thread(myRunnable).start();
                new Thread(myRunnable).start();
            }
        }*/

        System.out.println();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        },"线程3").start();
    }
}
