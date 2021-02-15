package 线程安全问题;

/**
 * 这样线程存在很大的安全问题，因为结果不一定是预期结果原子性问题)
 */
public class ThreadDemo {
    private static int n = 0;
    private static final int COUNT = 100000;
    static class Adder extends Thread{
        @Override
        public void run() {
                for (int i = 0;i < COUNT;i++){
                    n++;
                }
        }
    }

    static class Suber extends Thread{
        @Override
        public void run() {
                for (int i = 0;i < COUNT;i++){
                    n--;
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
