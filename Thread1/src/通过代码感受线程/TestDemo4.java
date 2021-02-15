package 通过代码感受线程;

import java.util.Random;

public class TestDemo4 {
    //1.冒泡排序
    public static void bubbleSort(long[] arr){
        for (int i = 0;i < arr.length-1;i++){
            for (int j = 0;j < arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    long tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    //2.创建数组
    public static long[] create(int n){
        long[] arr = new long[n];
        Random random = new Random();
        for (int i = 0;i < n;i++){
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    //3.单线程的
    public static void dan (){
        long begin = System.currentTimeMillis();
        //1.创建数组
        long[] a1 = create(4_0000);
        long[] a2 = create(4_0000);
        long[] a3 = create(4_0000);
        //2.排序
        bubbleSort(a1);
        bubbleSort(a2);
        bubbleSort(a3);
        long end = System.currentTimeMillis();
        //3.结束
        System.out.println("单线程时间是："+(end-begin)/1000.0);
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            long[] a = create(4_0000);
            bubbleSort(a);
        }
    }

    //多线程
    public static void thread() throws InterruptedException {
        long begin = System.currentTimeMillis();

        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = new Thread();
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        long e = System.currentTimeMillis();
        System.out.println("多线程时间是："+(e-begin)/1000.0);
    }
    public static void main(String[] args) throws InterruptedException {
        //dan();

        thread();

    }
}
