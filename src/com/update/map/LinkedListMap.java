package com.update.map;

/**
 * @author : liupu.
 * date : 2019/05/18
 * desc :
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            // 不存在 就直接添加
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            // 存在就替换值
            node.value = value;
        }
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newVaule) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " does not exist!");
        }

        node.value = newVaule;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {
        Node curr = dummyHead.next;
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(K key) {
            this(key, null);
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }
}
