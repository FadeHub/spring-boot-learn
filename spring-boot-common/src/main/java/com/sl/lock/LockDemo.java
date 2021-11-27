package com.sl.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Share{

    private int number =0;
    private  Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void incr() throws InterruptedException {
        lock.lock();
        try {
            while (number !=0) {
                condition.await();
            }
            number ++;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void decr() throws InterruptedException {
        lock.lock();
        try {
            while (number !=1) {
                condition.await();
            }
            number --;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
}

/**
 * @package: com.sl.lock
 * @author: shuliangzhao
 * @description:
 * @date 2021/11/2716:29
 */
public class LockDemo {

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
