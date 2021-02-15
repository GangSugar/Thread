package 多线程案列单例模式;

/**
 * 单列模型 —— 饿汉模式
 */
public class Singleton {
    //只有这么一个对象
    private static Singleton instance = new Singleton();

    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }
}
