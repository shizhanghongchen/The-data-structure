package com.mufeng.MaxHeap;

import com.mufeng.arrays.Array;

/**
 * Created by wb-yxk397023 on 2018/7/7.
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    /**
     * Heapify
     * @param arr
     */
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--){
            siftDown(i);
        }
    }

    /**
     * 返回堆中的元素个数
     * @return
     */
    public int getSize(){
        return data.getSize();
    }

    /**
     * 返回一个boolean值，表示堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引的父节点索引值
     * @param index
     * @return
     */
    private int parent(int index){
        if (index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个父节点的左节点的索引值
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个父节点的右节点的索引值
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 向堆中添加一个元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        // 执行siftUp操作
        siftUp(data.getSize() - 1);
    }

    /**
     * 元素上浮操作
     * @param k
     */
    private void siftUp(int k){
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 查看堆中的最大元素
     * @return
     */
    public E findMax(){
        if (data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 从堆中取出最大的元素
     * @return
     */
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 元素下沉
     * @param k
     */
    private void siftDown(int k){
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);

            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
            }

            if (data.get(k).compareTo(data.get(k)) >= 0){
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆中的最大元素，并替换成元素e
     * @param e
     * @return
     */
    public E replace(E e){
        E ret = findMax();

        data.set(0, e);
        siftDown(0);

        return ret;
    }
}
