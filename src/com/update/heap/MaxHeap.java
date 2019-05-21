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

    /**
     * 堆中元素上浮
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 找出最大的元素
     */
    public E findMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 找出 并 删除 堆中最大元素
     */
    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    /**
     * 堆中元素下沉
     */
    private void siftDown(int k) {
        while (leftChild(k) < size()) {
            int j = leftChild(k);
            if (j + 1 < size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            //此时  data[j] 是 leftChild 和 rightChild 中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }
}
