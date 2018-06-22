package com.mufeng.queues;

/**
 * Created by wb-yxk397023 on 2018/6/10.
 */
public class LoopQueues<E> implements Queues<E>{

    /**
     * 声明一个泛形数组
     */
    private E[] data;

    /**
     * 声明front，tail属性，用来维护循环队列
     */
    private int front, tail;

    /**
     * 声明队列的属性个数属性
     */
    private int size;

    /**
     * 有参构造器
     * @param capacity
     */
    public LoopQueues(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 无参构造器
     */
    public LoopQueues(){
        this(10);
    }

    /**
     * 获取队列容量（因为有意识的浪费一个空间，所以data.length需要执行-1的操作）
     * @return
     */
    public int getCapacity(){
        return data.length - 1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueues(E e) {
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeues() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeues from empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 获取对首的元素
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    /**
     * 获取队列中元素的个数
     * @return
     */
    @Override
    public int getSize(){
        return size;
    }

    /**
     * 队列扩容逻辑
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        // 创建新的容器
        E[] newData = (E[]) new Object[newCapacity + 1];
        // 使用循环进行赋值
        for (int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 重写toString
     * @return
     */
    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
