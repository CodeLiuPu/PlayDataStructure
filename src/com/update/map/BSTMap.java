package com.update.map;

/**
 * @author : liupu.
 * date : 2019/05/18
 * desc :
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) {
            node.left = add(node.left, key, value);
        } else if (compareResult > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V newVaule) {

    }

    /**
     * 返回以node为根节点的二分搜索树中，key所在的节点
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) {
            return getNode(node.left, key);
        } else if (compareResult > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }
}
