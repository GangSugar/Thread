package 多线程案列单例模式;

/**
 * 单列模型 —— 饿汉模式
 * 基本思想就是，什么时候用到，什么时候在初始化对象，
 * 和饿汉模式共同点，只会有一个对象
 */

public class Singleton1 {
    private static volatile Singleton1 instance = null;

    public static Singleton1 getInstance(){
        //有人要用到该对象了（多线程——二次判断——性能高——线程安全）
        if (instance == null){
            synchronized (Singleton1.class){
                if (instance == null){
                    instance = new Singleton1();
                }
            }
        }

        return instance;
    }
}
