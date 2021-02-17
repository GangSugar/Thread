package Executors的使用;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutoeDemo1 {
    public static void main(String[] args) {
        ExecutorService t1 = Executors.newCachedThreadPool();//这个方法返回一个ThreadPoolExecutor，但是只有临时工编制
        ExecutorService t2 = Executors.newFixedThreadPool(10);//这个方法是只允许有正式工
        ExecutorService t3 = Executors.newSingleThreadExecutor();//只有一个线程
    }
}
