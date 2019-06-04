package com.update.hashtable;

import java.util.TreeMap;

/**
 * @author : liupu.
 * date : 2019/06/03
 * desc : 哈希表 (又叫散列表)
 * 哈希算法 : 常见的可以模一个素数
 * <p>
 * //  int hash = 0;
 * //  for (int i = 0; i < s.length(); i++){
 * //      hash = hash + s.charAt(i) * M;
 * //  }
 */
public class HashTable<K, V> {

    private static final int initCapacity = 7;

    private TreeMap<K, V>[] data;
    private int size;
    private int M;

    public HashTable() {
        this(initCapacity);
    }

    public HashTable(int M) {
        this.M = M;
        size = 0;
        data = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            data[i] = new TreeMap<>();
        }
    }

    private int hash(K key) {
        // 消除hashcode 的符号 并取模
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = data[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = data[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = data[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        map.put(key, value);
    }

    public boolean contains(K key) {
        TreeMap<K, V> map = data[hash(key)];
        return map.containsKey(key);
    }

    public V get(K key) {
        TreeMap<K, V> map = data[hash(key)];
        return map.get(key);
    }

}