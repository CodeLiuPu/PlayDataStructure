package com.update.list;

/**
 * @author : liupu
 * date   : 2019/5/13
 * desc   :
 */
public class LinkedList<E> {
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get fail. Illegal index.");
        }
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set fail. Illegal index.");
        }
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.e = e;
    }

    public boolean contains(E e) {
        Node curr = dummyHead.next;
        while (curr != null) {
            if (curr.e.equals(e)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove fail. Illegal index.");
        }
        Node curr = dummyHead;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        Node node = curr.next;
        curr.next = node;
        node.next = null;
//        curr.next = curr.next.next;
        size--;
        return node.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node curr = dummyHead;
        while (curr.next != null) {
            if (curr.next.e.equals(e)) {
                Node node = curr.next;
                curr.next = node;
                node.next = null;
                size--;
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node curr = dummyHead.next;
        while (curr != null) {
            res.append(curr.e + "->");
            curr = curr.next;
        }
        res.append("NULL");
        return res.toString();
    }

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
