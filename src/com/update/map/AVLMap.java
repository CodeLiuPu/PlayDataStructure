package com.update.map;

import com.update.tree.AVLTree;

/**
 * @author : liupu.
 * date : 2019/06/02
 * desc :
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
    private AVLTree<K, V> data;

    public AVLMap() {
        data = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        data.add(key, value);
    }

    @Override
    public V remove(K key) {
        return data.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return data.contains(key);
    }

    @Override
    public V get(K key) {
        return data.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        data.set(key, newValue);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
