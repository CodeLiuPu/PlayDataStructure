package com.update.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历 根节点 在最后输出
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 前序遍历 非递归版
     */
    public void preOrderNR() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.println(curr.e);
            Node right = curr.right;
            Node left = curr.left;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.e);
            Node right = node.right;
            Node left = node.left;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
    }

    /**
     * 获取最小元素
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 获取最大元素
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
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

    /**
     * 从二分搜索树中删除最大值所在节点, 返回最大值
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        remove(root, e);
    }

    /**
     * 删除以 node 为根的,值为e的节点
     * 返回删除节点后新的 二分搜索树的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        int compareResult = e.compareTo(node.e);
        if (compareResult < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (compareResult > 0) {
            node.right = remove(node.right, e);
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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
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
