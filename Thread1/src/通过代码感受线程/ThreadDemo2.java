package 通过代码感受线程;

/**
 * 多线程的优势-增加运行速度
 */
public class ThreadDemo2 {
    private static final long count = 10_0000_0000;

    public static void main(String[] args) throws InterruptedException {
        //1.使用并发的方式，也就是多线程的方法
        concurrency();

        //2.使用串行的方式，也就是我们正常写代码的方式，对比多线程来说就是单线程，全部靠主线程来进行运算
        serial();
    }

    //多线程
    private static void concurrency() throws InterruptedException {
        long begin = System.currentTimeMillis();//开始运行时间
        //1.利用子线程计算a的值
        Thread thread = new Thread( new Runnable(){
            @Override
            public void run() {
                long a = 0;
                for (long i = 0;i < count;i++){
                    a++;
                }
            }
        });
        thread.start();
        //2.主线程计算b的值
        long b =0;
        for (long i = 0;i < count;i++){
            b++;
        }
        // 等待 thread 线程运行结束
        thread.join();

        long end = System.currentTimeMillis();//运行结束时间

        System.out.println("多线程时间是："+(end-begin));
    }

    //单线程
    private static void serial() {
        long begin = System.currentTimeMillis();//开始运行时间
        //1.将a和b的计算全部都放在主线程里面
        long a = 0;
        for (long i = 0;i < count;i++){
            a++;
        }

        long b = 0;
        for (long i = 0;i < count;i++){
            b++;
        }

        long end = System.currentTimeMillis();//运行结束时间

        System.out.println("单线程时间是："+(end-begin));
    }
}
