package com.update.tree;

/**
 * @author : liupu
 * date   : 2019/5/15
 * desc   : Binary-Search-Tree
 * 一棵二叉树
 * 每个叶子节点都含有一个Comparable的键
 * 每一个节点 大于左子树的任意节点 小于右子树的任意节点
 */
public class BST<E extends Comparable<E>> {
    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (null == root) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add(Node node, E e) {
        if (e.equals(node.e)) {
            // 元素已存在
            return;
        } else if (e.compareTo(node.e) < 0) {
            // 元素 小于 该节点
            if (node.left == null) {
                //  左子节点 为null 添加
                node.left = new Node(e);
                size++;
                return;
            } else {
                // 左子节点 不为空 则继续add
                add(node.left, e);
            }
        } else if (e.compareTo(node.e) > 0) {
            // 元素 大于 该节点
            if (node.right == null) {
                // 右子节点 为null 添加
                node.right = new Node(e);
                size++;
                return;
            } else { // 右子节点 不为空 则继续add
                add(node.right, e);
            }
        }
    }

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
