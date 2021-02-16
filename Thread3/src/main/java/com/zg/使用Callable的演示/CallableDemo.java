package com.zg.使用Callable的演示;

import java.util.concurrent.*;

/**
 * 使用Callable的演示类
 */
public class CallableDemo {
    //Integer是返回值类型
    static class MyCallable implements Callable<Integer> {
        private final int a;
        private final int b;

        MyCallable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        //上面Callable<Integer>返回值类型是Integer，那么call方法的返回值类型结束Integer
        @Override
        public Integer call() throws Exception {
            Thread.sleep(10_000);
            return a + b;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10)
        );
        ExecutorService executorService = threadPoolExecutor;
        Executor executor = threadPoolExecutor;

        Future<Integer> future = executorService.submit(new MyCallable(10, 20));

        System.out.println("Hello");
        Integer r = future.get();//获取值
        System.out.println("World");
        System.out.println(r);

    }
}
