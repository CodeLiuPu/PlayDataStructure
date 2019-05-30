package com.update.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liupu
 * date   : 2019/5/22
 * desc   : 平衡二叉树
 * 平衡二叉树 : 任意一个节点,左子树和右子树的高度差不能超过1
 * 平衡因子 : 左子树高度减去右子树高度
 */
public class AVLTree<K extends Comparable<K>, V> {
    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 判断该二叉树是否为二分搜索树
     */
    public boolean isBST() {
        // 中序遍历 判断是否key有序
        List<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 0; i < keys.size() - 1; i++) {
            if (keys.get(i).compareTo(keys.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, List<K> keys) {

        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    /**
     * 判断该二叉树是否为平衡二叉树
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * 判断该二叉树是否为平衡二叉树 递归算法
     */
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取 Node 的 Height
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (null == node) {
            size++;
            return new Node(key, value);
        }

        int compareResuklt = key.compareTo(node.key);

        if (compareResuklt == 0) {
            node.value = value;
        } else if (compareResuklt < 0) {
            node.left = add(node.left, key, value);
        } else {
            node.right = add(node.right, key, value);
        }
        // 更新 height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("unbalance : " + balanceFactor);
        }
        return node;
    }

    /**
     * 返回以node为根节点的二分搜索树中，key所在的节点
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        int compareResuklt = key.compareTo(node.key);
        if (compareResuklt == 0) {
            return node;
        } else if (compareResuklt < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }

    /**
     * 获取最小元素
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 获取最大元素
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }


    public void remove(K key) {
        remove(root, key);
    }

    /**
     * 删除以 node 为根的,值为e的节点
     * 返回删除节点后新的 二分搜索树的根
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (compareResult > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { // 值相等 进行删除逻辑
            if (node.left == null) { // 只有右孩子的节点
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }

            if (node.right == null) { // 只有左孩子的节点
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }

            // 左右孩子都不为空
            // 找到并待删除大的最小的节点
            // 使用该节点 替换待删除的节点
            Node rightMin = minimum(node.right);
            rightMin.left = node.left;
            rightMin.right = removeMin(node.right);
            node.left = null;
            node.right = null;
            return rightMin;

        }
    }

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }
}
