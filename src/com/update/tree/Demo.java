package com.update.tree;

/**
 * @author : liupu
 * date   : 2019/5/17
 * desc   :
 */
public class Demo {
    public static void main(String[] args) {
//        int[] arr = {5, 6, 2, 4, 8, 3, 1, 7, 9};
        int[] arr = {6, 3, 1, 2, 9};
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        System.out.println(bst);
        bst.removeMin();
        System.out.println(bst);
    }
}
