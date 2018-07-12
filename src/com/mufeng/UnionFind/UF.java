package com.mufeng.UnionFind;

/**
 * Created by wb-yxk397023 on 2018/7/11.
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
