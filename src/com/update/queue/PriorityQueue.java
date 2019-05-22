package com.update.queue;

import com.update.heap.MaxHeap;

/**
 * @author : liupu
 * date   : 2019/5/21
 * desc   : 优先队列 堆实现
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> data;

    public PriorityQueue() {
        data = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public E getFront() {
        return data.findMax();
    }

    @Override
    public void enqueue(E e) {
        data.add(e);
    }

    @Override
    public E dequeue() {
        return data.extractMax();
    }
}