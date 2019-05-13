package com.update.queue;

/**
 * @author : liupu
 * date   : 2019/5/13
 * desc   :
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    /**
     * 入队
     */
    void enqueue(E e);

    /**
     * 出队
     */
    E dequeue();

    /**
     * 获取队首元素
     */
    E getFront();
}