package com.common.javacore.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Created by Administrator on 2017/7/24.
 */
public class LockImpl implements Runnable {
    private volatile int tickets = 5;           // 定义票
    private Lock lock = new ReentrantLock();     // 定义锁对象
    public void run() {
        while (true) {
            try {
                // 加锁
                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + "正在出售第" + (tickets--) + "张票，被："+ Thread.currentThread().getName() +" 售出。");
                }
            } finally {
                // 释放锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockImpl str = new LockImpl();
        Thread tr1 = new Thread(str, "窗口1");
        Thread tr2 = new Thread(str, "窗口2");
        Thread tr3 = new Thread(str, "窗口3");
        tr1.start();
        tr2.start();
        tr3.start();
    }
}