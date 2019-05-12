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
}
