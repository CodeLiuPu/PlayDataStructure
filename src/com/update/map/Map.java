package com.update.map;

/**
 * @author : liupu.
 * date : 2019/05/18
 * desc :
 */
public interface Map<K, V> {
    void add(K k, V v);

    void remove(K k);

    boolean comtains(K k);

    V get(K k);

    void set(K k, V v);

    int getSize();

    boolean isEmpty();
}
