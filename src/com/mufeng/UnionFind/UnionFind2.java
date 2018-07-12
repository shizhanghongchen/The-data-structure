package com.mufeng.UnionFind;

/**
 * Created by wb-yxk397023 on 2018/7/11.
 */
public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size){
        parent = new int[size];
        for (int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
    }

    public int getSize(){
        return parent.length;
    }

    /**
     * 查看元素p和元素q是否所在同一集合
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot){
            return;
        }

        parent[qRoot] = pRoot;
    }

    /**
     * 查找p所对应的集合编号
     * @param p
     * @return
     */
    private int find(int p){

        if (p < 0 && p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }

        while (p != parent[p]){
            p = parent[p];
        }

        return p;
    }


}
