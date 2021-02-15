package 观察线程的所有状态;

public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        Thread.sleep(1);
        System.out.println(t.getState());
        t.join();
        System.out.println(t.getState());
    }
}
