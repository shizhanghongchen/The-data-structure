package com.mufeng.stacks;

import com.mufeng.linkedList.LinkedList;

/**
 * Created by wb-yxk397023 on 2018/6/22.
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFrist(e);
    }

    @Override
    public E pop() {
        return list.removeFrist();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    /**
     * 链表栈自测
     * @param args
     */
    public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
