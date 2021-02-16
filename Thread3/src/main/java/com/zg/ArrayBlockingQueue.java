package com.zg;

/**
 * 采用顺序表实现的阻塞式队列
 * //1.首先解决线程安全问题：经过分析，在方法上面见synchronized；
 * //2.解决通知机制：
 * 调offer的有可能去唤醒poll，调用poll的有可能去唤醒offer
 */

/**
 * 生产者只调用offer
 * 消费者只调用poll
 */
public class ArrayBlockingQueue {
    private Integer[] array = new Integer[5];
    private int size = 0;
    private int headIndex = 0;//队列中的第一个元素的下标
    private int rearIndex = 0;//队尾中，下一个可以放入元素的下标(也就是队尾元素所在下标的下一个)

    public synchronized boolean offer(Integer e) throws InterruptedException {
        //临界区开始
        while (size >= array.length){//满了
            wait();//Object.wait()；//有可能你醒过来，条件还没有满足，因为不知道谁唤醒的，所以使用while
        }

        array[rearIndex] = e;
        rearIndex++;
        if (rearIndex == array.length){
            rearIndex = 0;
        }
        size++;

        notifyAll();//大赦天下
        //临界区结束
        return true;
    }

    public synchronized Integer poll() throws InterruptedException {
        while (size <= 0){
            wait();//有可能你醒过来，条件还没有满足，因为不知道谁唤醒的，所以使用while
        }

        Integer e = array[headIndex];
        headIndex++;
        if (headIndex == array.length){
            headIndex = 0;
        }
        size--;

        notifyAll();//大赦天下
        return e;
    }
}
