package 使用Java中定时器;

import java.util.Timer;
import java.util.TimerTask;

public class TimeOutDemo {
    public static void main(String[] args) throws InterruptedException {
        //TimerTask:让定时器去运行任务
        //Timer:定时器

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("时间到了，该起床了");
            }
        };

        Timer timer = new Timer();
        //timer.schedule(task,5000);//5秒之后去执行任务
        timer.scheduleAtFixedRate(task,5000,3000);//5秒之后闹钟第一次响，然后之后就是每三秒响

        while (true){
            System.out.println("我是主线程，我在睡觉");
            Thread.sleep(5000);
        }
    }
}
