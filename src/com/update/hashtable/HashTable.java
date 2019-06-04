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

}
