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
        int compareResult = e.compareTo(node.e);
        if (compareResult == 0) {
            return;
        } else if (compareResult < 0) {
            if (node.left == null) {
                node.left = new Node(e);
                size++;
                return;
            } else {
                add(node.left, e);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(e);
                size++;
                return;
            } else {
                add(node.right, e);
            }
        }
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        int compareResult = e.compareTo(node.e);
        if (compareResult == 0) {
            return true;
        } else if (compareResult < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历 根节点 先输出
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历 根节点 在中间输出
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
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
