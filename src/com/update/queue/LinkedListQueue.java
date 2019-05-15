package com.update.queue;


public class LinkedListQueue<E> implements Queue<E> {
    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (null == tail) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node node = head;
        head = head.next;
        node.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return node.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node curr = head;
        while (curr != null) {
            res.append(curr.e + "->");
            curr = curr.next;
        }
        res.append("NULL tail.");
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
