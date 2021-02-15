package 通过代码感受线程;

public class ThreadDemo3 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            int n = 5;
            while(n-- > 0){
                System.out.println("我是子线程");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();//导致此线程开始执行; Java虚拟机调用此线程的run方法
        int n = 5;
        while (n-- > 0){
            System.out.println("我是主线程");
        }
    }
}
