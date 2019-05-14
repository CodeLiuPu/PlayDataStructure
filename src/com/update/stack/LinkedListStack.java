package com.update.stack;

import com.update.list.LinkedList;

/**
 * @author : liupu.
 * date : 2019/05/14
 * desc :
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> data;

    public LinkedListStack() {
        data = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addFirst(e);
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(data);
        return res.toString();
    }
}
