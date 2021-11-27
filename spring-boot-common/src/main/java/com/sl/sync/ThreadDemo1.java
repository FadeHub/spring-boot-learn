package com.sl.sync;

class Share{

    private int number = 0;

    public synchronized void incr() throws InterruptedException {
        while(number !=0) { //不能使用if判断，否则会出现虚假唤醒
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+ ":" +number);
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        while(number !=1) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+ ":" +number);
        this.notifyAll();
    }


}

/**
 * 例子的结果是AA:1 BB:0 CC:1 DD:0
 * @author: shuliangzhao
 * @date 2021/11/2716:09
 */
public class ThreadDemo1 {

    public static void main(String[] args) {
        Share share = new Share();

        new Thread(()-> {
            for (int i = 1; i <= 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()-> {
            for (int i = 1; i <= 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(()-> {
            for (int i = 1; i <= 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(()-> {
            for (int i = 1; i <= 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}
