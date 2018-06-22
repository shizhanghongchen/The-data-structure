package com.mufeng.queues;

/**
 * Created by wb-yxk397023 on 2018/6/23.
 */
public class LinkedListQueues<E> implements Queues<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueues(){
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
    public void enqueues(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeues() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if (head == null){
            tail = null;
        }

        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args){

        LinkedListQueues<Integer> queue = new LinkedListQueues<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueues(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeues();
                System.out.println(queue);
            }
        }
    }

}
