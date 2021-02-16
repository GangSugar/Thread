package com.zg.线程池演示;

import java.util.concurrent.*;

public class ThreadPool {
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 0;i < 10;i++){
                System.out.println("好人");
            }
        }
    }

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,10,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        ExecutorService executorService = new ThreadPoolExecutor(10,10,10,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        Executor executor = new ThreadPoolExecutor(10,10,10,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));

        executor.execute(new MyRunnable());

        for (int i =0;i < 100;i++){
            System.out.println("world");
        }

        executorService.shutdown();
        //threadPoolExecutor.shutdown();
    }
}
