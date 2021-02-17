package 自定义线程池;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 自己实现的线程池类
 */
public class MyThreadPoolDemo {
    private Thread[] threads;
    private BlockingQueue<Runnable> taskQueue;//阻塞式队列

    private static class Worker extends Thread{
        private final BlockingQueue<Runnable> taskQueue;//提前写好一个工作线程
        Worker(BlockingQueue<Runnable> taskQueue){
            this.taskQueue = taskQueue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    while (!Thread.interrupted()){//只要没有中断之前，我就一直执行任务
                        //1.首先取任务
                        Runnable take = taskQueue.take();

                        //2.执行任务
                        take.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public MyThreadPoolDemo(int nThreads){
        this.threads = new Thread[nThreads];
        taskQueue = new LinkedBlockingDeque<>();
        //提前创建nThread个"工作线程"
        for (int i = 0;i < nThreads;i++){
            Thread worker = new Worker(taskQueue);
            worker.start();
            threads[i] = worker;
        }
    }

    public void execute(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }

    public void shutdown() throws InterruptedException {
        for (Thread thread : threads){
            thread.interrupt();//将所有任务都停下来
        }

        for (Thread thread : threads){//等待所有任务退出
            thread.join();
        }
    }
}
