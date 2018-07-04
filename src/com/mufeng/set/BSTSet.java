package com.mufeng.set;

import com.mufeng.binarySearchTree.BST;

/**
 * Created by wb-yxk397023 on 2018/7/4.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    /**
     * 引入二分搜索树
     */
    private BST<E> bst;

    /**
     * 初始化bst
     */
    public BSTSet(){
        bst = new BST<>();
    }
    /**
     * 向集合中添加元素(实现去重添加)
     * @param e
     */
    @Override
    public void add(E e) {
        bst.add(e);
    }

    /**
     * 从集合中删除一个元素
     * @param e
     */
    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    /**
     * 查看集合中是否包含元素e
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    /**
     * 获取集合中元素的个数
     * @return
     */
    @Override
    public int getSize() {
        return bst.size();
    }

    /**
     * 查看集合是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
