package com.update.stack;

import com.update.array.Array;

/**
 * @author : liupu
 * date   : 2019/5/13
 * desc   :
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> data;

    public ArrayStack() {
        data = new Array<>();
    }

    public ArrayStack(int capacity) {
        data = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int getCapacity() {
        return data.getCapacity();
    }

    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack : \n");
        res.append("[");
        for (int i = 0; i < data.getSize(); i++) {
            res.append(data.get(i));
            if (i != data.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
