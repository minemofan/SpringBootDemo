package com.common.javacore.barrier;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/7/24.
 */
public class CyclicBarrierImpl implements Runnable{
    private CyclicBarrier cyclicBarrier;
    private int id;

    public CyclicBarrierImpl(int id, CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
        this.id = id;
    }
    @Override
    public void run() {
        try {
            System.out.println("玩家" + id + "正在玩第一关...");
            cyclicBarrier.await();
            System.out.println("玩家" + id + "进入第二关...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            public void run() {
                System.out.println("所有玩家进入第二关！");
            }
        });
        for (int i = 0; i < 3; i++) {
            new Thread(new CyclicBarrierImpl(i, cyclicBarrier)).start();
        }
    }
}
