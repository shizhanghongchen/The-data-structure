package com.mufeng.segmentTree;

/**
 * Created by wb-yxk397023 on 2018/7/8.
 */
public interface Merger<E> {
    E merge(E a, E b);
}
