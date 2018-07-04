package com.mufeng.set;

import com.mufeng.linkedList.LinkedList;

/**
 * Created by wb-yxk397023 on 2018/7/4.
 */
public class LinkedListSet<E> implements Set<E> {

    /**
     * 引入链表
     */
    private LinkedList<E> linkedList;

    /**
     * 初始化
     */
    public LinkedListSet(){
        linkedList = new LinkedList<>();
    }

    /**
     * 向集合中添加元素(去重添加)
     * @param e
     */
    @Override
    public void add(E e) {
        // 实现去重添加元素e
        if (!linkedList.contains(e)){
            linkedList.addFrist(e);
        }
    }

    /**
     * 从集合中删除元素
     * @param e
     */
    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    /**
     * 查看集合是否包含元素e
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    /**
     * 获取集合中元素的个数
     * @return
     */
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    /**
     * 查看集合是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
