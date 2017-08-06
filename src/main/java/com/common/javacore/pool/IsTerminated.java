package com.common.javacore.pool;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/7/22.
 */
@Component
public class IsTerminated {

    public static void main(String[] args){
        IsTerminated ist = new IsTerminated();
        ist.ShutDownTest();
        //ist.ShutDownNowTest();
    }

    public void ShutDownTest(){
        ExecutorService exe = Executors.newFixedThreadPool(3);
        try {
            int threadNum = 0;
            for(int i=0;i<7;i++){
                threadNum++;
                final int currentThreadNum = threadNum;
                exe.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("子线程[" + currentThreadNum + "]开启");
                            Thread.sleep(1000*10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally{
                            System.out.println("子线程[" + currentThreadNum + "]结束");
                        }
                    }
                });
            }
            System.out.println("已经开启所有的子线程");
           exe.shutdown();
            //  exe.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("shutdown()：启动一次顺序关闭，执行以前提交的任务，但不接受新任务。");
            while(true){
                if(exe.isTerminated()){
                    System.out.println("所有的子线程都结束了！");
                    break;
                }
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("主线程结束");
        }
    }


    public void ShutDownNowTest(){
        ExecutorService exe = Executors.newFixedThreadPool(3);
        try {
            int threadNum = 0;
            for(int i=0;i<7;i++){
                threadNum++;
                final int currentThreadNum = threadNum;
                exe.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("子线程[" + currentThreadNum + "]开启");
                            Thread.sleep(1000*10);
                        } catch (InterruptedException e) {
                            System.out.println("子线程[" + currentThreadNum + "]异常");
                            e.printStackTrace();
                        }finally{
                            System.out.println("子线程[" + currentThreadNum + "]结束");
                        }
                    }
                });
            }
            System.out.println("已经开启所有的子线程");
            exe.shutdownNow();

            System.out.println("shutdownNow()：强迫所有任务停止工作。");
            while(true){
                if(exe.isTerminated()){
                    System.out.println("所有的子线程都结束了！");
                    break;
                }
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("主线程结束");
        }
    }
}
