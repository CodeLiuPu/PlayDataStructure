package com.update.tree;

/**
 * @author : liupu.
 * date : 2019/06/02
 * desc : 红黑树
 * 1. 每个节点是红色或者黑色的
 * 2. 根节点是黑色的
 * 3. 每一个叶子节点(最后的空节点 NULL) 是黑色的
 * 4. 如果一个节点是红色的,那么他的孩子节点都是黑色的
 * 5. 从任意一个节点到叶子节点,经过的黑色节点都是一样的
 */
public class RBTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断节点的颜色
     */
    public boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    /**
     * //   node                     x
     * //  /   \     左旋转         /  \
     * // T1   x   --------->   node   T3
     * //     / \              /   \
     * //    T2 T3            T1   T2
     */
    private Node leftRotate(Node node) {
        Node x = node.right;

        // 左旋转
        node.right = x.left;
        x.left = node;

        // 维护颜色
        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * //     node                   x
     * //    /   \     右旋转       /  \
     * //   x    T2   ------->   y   node
     * //  / \                       /  \
     * // y  T1                     T1  T2
     */
    private Node rightRotate(Node node) {
        Node x = node.left;

        // 右旋转
        node.left = x.right;
        x.right = node;

        // 维护颜色
        x.color = node.color;
        node.color = RED;

        return x;
    }

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }
}