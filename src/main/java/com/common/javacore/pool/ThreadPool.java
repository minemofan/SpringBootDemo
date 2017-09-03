package com.common.javacore.pool;

import java.util.LinkedList;
import java.util.List;
/**
 * Created by Administrator on 2017/7/22.
 * description：
 *  线程池类：
 *      1、创建线程
 *      2、执行任务
 *      3、销毁线程
 *      4、获取线程基本信息
 */
public class ThreadPool {

    //初始线程数
    private static int worker_num = 5;

    //工作线程数组
    private WorkThread[] workThreads;

    /* 未处理的任务
   ``* volatile 修饰的成员变量在每次被线程访问时
     * ，本质是在告诉jvm当前变量在寄存器（工作内存）中的值是不确定的，需要从主存（共享内存）中读取。
     */
    private static volatile  int finished_task = 0;

    /*
     * 任务队列，作为一个缓冲,List线程不安全
     * add() 往likedlist中加入元素
     * remove(int index) 根据下标去除元素，并从链中删除
     * wait() 休眠
     * notify() 唤醒
     */
    private List<Runnable> taskQueue = new LinkedList<Runnable>();

    /* 构造器
    * */
    private static ThreadPool threadPool;

    private ThreadPool(){ this(5); }

    //根据指定初始线程数，创建线程池
    private ThreadPool(int worker_num){
        ThreadPool.worker_num = worker_num;         //默认线程个数
        workThreads = new WorkThread[worker_num]; //初始化工作线程数组
        //创建新线程
        for(int i=0;i<worker_num;i++){
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
    }

    //获取线程池(默认:worker_num = 5)
    public static ThreadPool getThreadPool(){
        return getThreadPool(ThreadPool.worker_num);
    }

    //获取线程池（根据指定线程数）
    public static ThreadPool getThreadPool(int worker_num){
        if(worker_num <= 0){
            worker_num = ThreadPool.worker_num;
        }
        if(threadPool ==  null){
            threadPool = new ThreadPool(worker_num);
        }
        return threadPool;
    }

    //执行任务,其实只是把任务加入任务队列，什么时候执行有线程池管理器决定
    public void execute(Runnable task){
        synchronized(taskQueue) {
            taskQueue.add(task);
            taskQueue.notify();
        }
    }

    // 批量执行任务,其实只是把任务加入任务队列，什么时候执行有线程池管理器觉定
    public void execute(Runnable[] task) {
        synchronized (taskQueue) {
            for (Runnable t : task){
                taskQueue.add(t);
            }
            taskQueue.notify();
        }
    }

    // 批量执行任务,其实只是把任务加入任务队列，什么时候执行有线程池管理器觉定
    public void execute(List<Runnable> task) {
        synchronized (taskQueue) {
            for (Runnable t : task) {
                taskQueue.add(t);
            }
            taskQueue.notify();
        }
    }

    /**
     * 内部类: 工作线程
     */
    private class WorkThread extends Thread {
        //该线程是否有效，用于结束该工作线程
        private boolean isRunning = true;

        /**
         * 如果认为队列不为空，则取出任务执行，若任务队列为空，则等待
         */
        public void run(){
            Runnable runnable = null;
            while (isRunning){
                synchronized (taskQueue){
                    while (isRunning && taskQueue.isEmpty()){
                        //队列为空，等待
                        try {
                            taskQueue.wait(20);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    if(!taskQueue.isEmpty()){
                        //取出任务,并从队列中删除
                        runnable = taskQueue.remove(0);
                    }

                    //执行任务
                    if(runnable != null){
                        runnable.run();
                    }
                    finished_task ++;
                    runnable = null;
                }
            }
        }

        // 停止工作，让该线程自然执行完run方法，自然结束
        public void stopWorker() {
            isRunning = false;
        }
    }

    public void destroy(){
        while (!taskQueue.isEmpty()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //工作线程停止任务
        for(int i=0;i<worker_num;i++){
            workThreads[i].stopWorker();
            workThreads[i] = null;
        }
        threadPool = null;
        taskQueue.clear(); //清空任务队列
    }


    // *******************************   getter  setter  *******************************
    // 返回工作线程的个数
    public int getWorkThreadNumber() {
        return worker_num;
    }

    // 返回已完成任务的个数,这里的已完成是只出了任务队列的任务个数，可能该任务并没有实际执行完成
    public int getFinishedTasknumber() {
        return finished_task;
    }

    // 返回任务队列的长度，即还没处理的任务个数
    public int getWaitTasknumber() {
        return taskQueue.size();
    }

    // 覆盖toString方法，返回线程池信息：工作线程个数和已完成任务个数
    @Override
    public String toString() {
        return "WorkThread number:" + worker_num + "  finished task number:"
                + finished_task + "  wait task number:" + getWaitTasknumber();
    }

}