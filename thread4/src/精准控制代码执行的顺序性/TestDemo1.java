package 精准控制代码执行的顺序性;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo1 {
    //ReentrantLock是可重入锁
    private static Lock lock= new ReentrantLock();

    //信号量
    private static String signal;

    static class Runner extends Thread{

        @Override
        public void run() {
           while (true){
               //申请锁
               lock.lock();
               while(!signal.equals("A")){
                   //发现不是"A"赶紧释放掉锁
                   lock.unlock();
                   //这里还需要放弃掉CPU
                   Thread.yield();//这个可加也可以不加，加上是用来提高性能的

                   lock.lock();//因为这个过程其他线程也会申请到锁，修改了signal的值
               }
               //循环退出这一刻是持有锁的；

               System.out.println("A线程在执行");
               signal = "B";

               //释放锁
               lock.unlock();
           }
        }
    }

    static class BRunner extends Thread{

        @Override
        public void run() {
            while (true){
                //申请锁
                lock.lock();
                while(!signal.equals("B")){
                    //发现不是"A"赶紧释放掉锁
                    lock.unlock();
                    //这里还需要放弃掉CPU
                    Thread.yield();

                    lock.lock();//因为这个过程其他线程也会申请到锁，修改了signal的值
                }
                //循环退出这一刻是持有锁的；

                System.out.println("B线程在执行");
                signal = "C";

                //释放锁
                lock.unlock();
            }
        }
    }

    static class CRunner extends Thread{
        @Override
        public void run() {
            while (true){
                //申请锁
                lock.lock();
                while(!signal.equals("C")){
                    //发现不是"A"赶紧释放掉锁
                    lock.unlock();
                    //这里还需要放弃掉CPU
                    Thread.yield();

                    lock.lock();//因为这个过程其他线程也会申请到锁，修改了signal的值
                }
                //循环退出这一刻是持有锁的；

                System.out.println("C线程在执行");
                signal = "A";

                //释放锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runner a = new Runner();
        BRunner b = new BRunner();
        CRunner c = new CRunner();

        signal = "C";//想让谁运行，就先赋值谁

        a.start();
        Thread.sleep(2000);
        b.start();
        Thread.sleep(2000);
        c.start();
    }
}
