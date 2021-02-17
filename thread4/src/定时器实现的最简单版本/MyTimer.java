package 定时器实现的最简单版本;

public class MyTimer {
    static abstract class TimerTask{
        public abstract void run();
    }
    static class Timer{
        public void schedule(TimerTask task,long delay){
            Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(delay);
                        task.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("时间到了，干活!");
            }
        },5000);

        while (true){
            System.out.println("我是主线程");
            Thread.sleep(5000);
        }
    }
}
