package com.mufeng.stacks;

import com.mufeng.arrays.Array;

/**
 * Created by wb-yxk397023 on 2018/6/9.
 */
public class ArrayStack<E> implements Stack<E> {

    /**
     * 引入数组
     */
    private Array<E> array;

    /**
     * ArrayStack有参构造器
     * @param capacity
     */
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * ArrayStack无参构造器
     */
    public ArrayStack(){
        array = new Array<>();
    }

    /**
     * 获取栈中元素的个数
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 向栈中添加一个元素
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 出栈
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 获取栈的容量
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 重写toString
     * @return
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++){
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
