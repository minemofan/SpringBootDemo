package com.common.javacore.barrier;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/7/24.
 */
public class CountDownLatchImpl implements Runnable{
    private int id;
    private CountDownLatch beginSignal;
    private CountDownLatch endSignal;
    public CountDownLatchImpl(int id, CountDownLatch begin, CountDownLatch end) {
        this.id = id;
        this.beginSignal = begin;
        this.endSignal = end;
    }
    @Override
    public void run() {
        try {
            beginSignal.await();
            System.out.println("起跑..."+ id);
            System.out.println("work" + id + "到达终点");
            endSignal.countDown();
            System.out.println("work" + id + "继续干其他事情");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CountDownLatch begSignal = new CountDownLatch(1);
        CountDownLatch endSignal = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(new CountDownLatchImpl(i, begSignal, endSignal)).start();
        }
        try {
            begSignal.countDown();  //统一起跑
            endSignal.await();      //等待运动员到达终点
            System.out.println("结果发送到汇报成绩的系统");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
