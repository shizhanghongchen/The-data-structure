package com.mufeng.MaxHeap;

/**
 * Created by wb-yxk397023 on 2018/6/9.
 */
public interface Queues<E> {

    /**
     * 获取队列中元素的个数
     * @return
     */
    int getSize();

    /**
     * 判断队列中是否是空的
     * @return
     */
    boolean isEmpty();

    /**
     * 向队列中添加一个元素(入队)
     * @param e
     */
    void enqueues(E e);

    /**
     * 从队列中删除一个元素(出队)
     * @return
     */
    E dequeues();

    /**
     * 获取对首的元素
     * @return
     */
    E getFront();
}
