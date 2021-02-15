package 观察线程的所有状态;

public class ThreadDemo {
    /**
     * 观察线程的所有状态，总共有6中状态
     * NEW ：新建
     * RUNNABLE ：就绪
     * BLOCKED ： 阻塞
     * WAITING：等待
     * TIMED_WAITING ：带时限的等待(超时等待)
     * TERMINATED ： 终止
     * @param args
     */
    public static void main(String[] args) {
        for (Thread.State state : Thread.State.values()){
            System.out.println(state);
        }
    }
}
