package com.update.map;

/**
 * @author : liupu.
 * date : 2019/05/18
 * desc :
 */
public interface Map<K, V> {
    /**
     * key 要求唯一
     */
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newVaule);

    int getSize();

    boolean isEmpty();
}
