package com.update.heap;

import com.update.array.Array;

/**
 * @author : liupu.
 * date : 2019/05/20
 * desc :
 * 完全二叉树: 不一定是满二叉树,但缺失部分一定在树的右下侧
 * 二叉堆 : 是一个完全二叉树,
 * 堆中某个节点的值总是不大于其父节点的值(最大堆)
 * <p>
 * parent (i) = (i - 1) / 2
 * ==> parentI = (childI - 1) / 2
 * <p>
 * left child (i) = i * 2 + 1
 * ==> leftChildI = parentI * 2 + 1
 * <p>
 * right child (i) = i * 2 + 2
 * ==> rightChildI = parentI * 2 + 2
 * <p>
 * PS: i 为 数组索引 从0开始
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中
     * 一个索引所表示的元素的 父节点 的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 does not have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中
     * 一个索引所表示的元素的 左子节点 的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中
     * 一个索引所表示的元素的 右子节点 的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0) {
            E self = data.get(k);
            E parent = data.get(parent(k));

            if (parent.compareTo(self) < 0) {
                data.swap(k, parent(k));
                k = parent(k);
            } else {
                break;
            }
        }
    }
}
