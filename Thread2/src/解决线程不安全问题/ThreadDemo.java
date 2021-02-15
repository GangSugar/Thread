package 解决线程不安全问题;

/**
 * synchronized的语法使用示例
 */
public class ThreadDemo {
    //同步方法
    synchronized int add(int a,int b){
        return 0;
    }

    synchronized static void sayHello(){

    }

    //同步代码块——能出现语句的地方
    static void someMethod() {
        Object object = new Object();
        synchronized (object) {

        }
    }
}
