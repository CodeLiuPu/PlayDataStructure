package com.update.list;

/**
 * @author : liupu
 * date   : 2019/5/13
 * desc   :
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node() {
            this(null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
