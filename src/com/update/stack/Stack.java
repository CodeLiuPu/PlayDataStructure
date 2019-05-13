package com.update.stack;

/**
 * @author : liupu
 * date   : 2019/5/13
 * desc   :
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    /**
     * 压栈 将元素压进栈顶
     */
    void push(E e);

    /**
     * 出栈
     * 返回栈顶的元素,并且将该栈顶元素出栈
     */
    E pop();

    /**
     * 返回栈顶的元素,不弹出该栈顶元素
     *
     * @return
     */
    E peek();
}
