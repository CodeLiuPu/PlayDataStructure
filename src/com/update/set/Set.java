package com.update.set;

/**
 * @author : liupu.
 * date : 2019/05/17
 * desc :
 */
public interface Set<E> {
    int getSize();

    boolean isEmpty();

    /**
     * 不能添加重复的元素
     */
    void add(E e);

    void remove(E e);

    boolean contains(E e);

}
