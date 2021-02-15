package 解决线程不安全问题;

public class ThreadDemo2 {
    private static int n = 0;
    private static final int COUNT = 100000;
    private static Object lock = new Object();

    static class Adder extends Thread{
        @Override
        public void run() {
            for (int i = 0;i < COUNT;i++){
//                synchronized (Adder.class){
//                    n++;
//                }
                synchronized (lock){
                    n++;
                }
            }
        }
    }

    static class Suber extends Thread{
        @Override
        public void run() {
            for (int i = 0;i < COUNT;i++){
//               synchronized (Adder.class){//一定和上面的加同一把锁
//                   n--;
//               }
                synchronized (lock){
                    n--;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Adder();
        Thread t2 = new Suber();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(n);
    }
}
