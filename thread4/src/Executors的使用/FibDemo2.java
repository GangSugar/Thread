package Executors的使用;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池实现斐波那契数列
 */
public class FibDemo2 {
    private static long fib(int n){
        if (n <= 1){
            return 1;
        }

        return fib(n-1)+fib(n-2);
    }

    static class CalcTask implements Runnable{
        private int n;
        CalcTask(int n){
            this.n = n;
        }
        @Override
        public void run() {
            long fib = fib(n);
            System.out.printf("fib(%d) = %d\n",n,fib);
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int n = scan.nextInt();

            Runnable task = new CalcTask(n);

            threadPool.execute(task);
        }

        threadPool.shutdown();//关闭线程池
    }
}
