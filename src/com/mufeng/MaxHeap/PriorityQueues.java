package com.mufeng.MaxHeap;

/**
 * Created by wb-yxk397023 on 2018/7/7.
 */
public class PriorityQueues<E extends Comparable<E>> implements Queues<E> {

    /**
     * 引入MaxHeap
     */
    private MaxHeap<E> maxHeap;

    /**
     * 构造器
     */
    public PriorityQueues(){
        maxHeap = new MaxHeap<>();
    }


    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueues(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeues() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
