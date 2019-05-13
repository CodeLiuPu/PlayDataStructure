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

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get fail. Require index >= 0 & index <= size");
        }
        return data[index];
    }

    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set fail. Require index >= 0 & index <= size");
        }
        data[index] = e;
    }

    public boolean contains(int e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(int e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove fail. Require index >= 0 & index <= size");
        }
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public void removeElement(int e) {
        int index = find(e);
        if (-1 != index) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
