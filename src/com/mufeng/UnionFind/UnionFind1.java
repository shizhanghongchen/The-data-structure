package com.mufeng.UnionFind;

/**
 * Created by wb-yxk397023 on 2018/7/11.
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size){
        id = new int[size];

        for (int i = 0; i < id.length; i++){
            id[i] = i;
        }
    }

    /**
     * 获取并查集长度
     * @return
     */
    @Override
    public int getSize(){
        return id.length;
    }

    /**
     * 查看元素p和元素q是否在同一集合
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID){
            return;
        }

        for (int i = 0; i < id.length; i++){
            if (id[i] == pID)
                id[i] = qID;
        }
    }

    /**
     * 查找元素p所对应的集合编号
     * @param p
     * @return
     */
    private int find(int p){
        if (p < 0 && p >= id.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }
}
