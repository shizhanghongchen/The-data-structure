package com.mufeng.set;

/**
 * Created by wb-yxk397023 on 2018/7/4.
 */
public interface Set<E> {

    /**
     * 向集合中添加元素(实现去重的操作)
     * @param e
     */
    void add(E e);

    /**
     * 从集合中删除元素
     * @param e
     */
    void remove(E e);

    /**
     * 查询集合中是否有相同元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 获取集合中元素的个数
     * @return
     */
    int getSize();

    /**
     * 查看集合是否为空
     * @return
     */
    boolean isEmpty();
}
