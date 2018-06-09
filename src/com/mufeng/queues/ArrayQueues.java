package com.mufeng.queues;

import com.mufeng.arrays.Array;

/**
 * Created by wb-yxk397023 on 2018/6/9.
 */
public class ArrayQueues<E> implements Queues<E> {

    /**
     * 引入数组
     */
    private Array<E> array;

    /**
     * 有参构造器
     * @param capacity
     */
    public ArrayQueues(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * 无参构造器
     */
    public ArrayQueues(){
        array = new Array<>();
    }

    /**
     * 获取队列中的元素个数
     * @return
     */
    @Override
    public int getsize() {
        return array.getSize();
    }

    /**
     * 判断队列中是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 向队列中插入一个元素
     * @param e
     */
    @Override
    public void enqueues(E e) {
        array.addLast(e);
    }

    /**
     * 从队列中删除一个元素
     * @return
     */
    @Override
    public E dequeues() {
        return array.removeFirst();
    }

    /**
     * 查询对首的元素
     * @return
     */
    @Override
    public E getFront() {
        return array.getFrist();
    }

    /**
     * 获取队列的容量
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
        res.append("Queues: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++){
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
