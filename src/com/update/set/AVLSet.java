package com.update.set;

import com.update.tree.AVLTree;

/**
 * @author : liupu.
 * date : 2019/06/02
 * desc :
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {
    private AVLTree<E, Object> data;

    public AVLSet() {
        data = new AVLTree<>();
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
    public void add(E e) {
        data.add(e, null);
    }

    @Override
    public void remove(E e) {
        data.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return data.contains(e);
    }
}
