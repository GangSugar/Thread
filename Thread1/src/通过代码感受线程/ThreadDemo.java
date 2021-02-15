package 通过代码感受线程;

import java.util.Random;

public class ThreadDemo {
    /**
     * 内部实现静态线程类
     */
    private static class MyThread extends Thread{
        //1.重写run方法

        @Override
        public void run() {
            //System.out.println("第一个线程代码感受!");
            Random random = new Random();
            while (true) {
                // 打印线程名称
                System.out.println(Thread.currentThread().getName());
                try {
                    // 随机停止运行 0-9 秒
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*private static class MyThread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("继承Runable实现线程");
        }
    }*/

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        /*t1.start();
        t2.start();
        t3.start();*/

        // 使用 lambda 表达式创建 Runnable 子类对象
        Thread t4 = new Thread(() -> System.out.println("使用匿名类创建 Thread 子类对象"));
        Thread t5 = new Thread(() -> {
            System.out.println("使用匿名类创建 Thread 子类对象");
        });
        t4.start();
        t5.start();


        Random random = new Random();
        /*while (true){
            //currentThread()返回对当前正在执行的线程对象的引用
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        //MyThread2 myThread2 = new MyThread2();
        //new Thread(myThread2).start();
    }
}
