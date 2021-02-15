package 中断线程的方法演示;

public class MyInterinterrupt {
    public static class MyThread extends Thread{
        @Override
        public void run() {
            while (true){
                try{
                    Thread.sleep(10000);
                }catch (InterruptedException e){
                    System.out.println("我收到中断异常了");
                }
                System.out.println("hello word");
                boolean is = Thread.interrupted();//返回true，代表有人让它中断
                if (is){
                    System.out.println(is);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();

        Thread.sleep(1000);

        t.interrupt();//对象调用，这个中断sleep，wait，join这些，也会清除标志位，单独不会
        //interrupted()是静态的只能Thread调用，会清除标志位
        //isInterrupted是对象调用，这个只是测试
    }
}
