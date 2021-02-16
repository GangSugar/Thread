package com.zg;

public class QueueDemo {
    static ArrayBlockingQueue queue = new ArrayBlockingQueue();

    //生产者
    static class Producer extends Thread{
        @Override
        public void run() {
            setName("生产者");
           while(true){
               try {
                   queue.offer(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }


    //消费者
    static class Consumer extends Thread{
        @Override
        public void run() {
            setName("消费者");
            try {
                queue.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < 5;i++){
            Thread t1 = new Producer();//生产者
            t1.start();
        }

        for (int i = 0;i < 5;i++){
            Thread t = new Consumer();//消费者
            t.start();
        }
    }
}
