package com.update.array;

/**
 * @author : liupu.
 * date : 2019/05/11
 * desc : 自定义Array
 */
public class Array {
    private int[] data;
    private int size;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int e) {
        add(0, e);
    }

    public void addLast(int e) {
        add(size, e);
    }

    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add fail. Array is full.");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail. Require index >= 0 & index <= size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;

    }
}
