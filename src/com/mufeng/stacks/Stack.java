package com.mufeng.stacks;

/**
 * Created by yangxiaokai on 2018/6/9.
 */
public interface Stack<E> {

    /**
     * 获取栈中元素的个数
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 向栈中添加一个元素
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();
}
