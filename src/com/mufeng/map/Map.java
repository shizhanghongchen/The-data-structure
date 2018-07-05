package com.mufeng.map;

/**
 * Created by wb-yxk397023 on 2018/7/5.
 */
public interface Map<K, V> {

    /**
     * 向Map中添加元素
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 根据K值找到V，并从Map中删除
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 根据K值查看Map中是否包含该元素
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 根据K值查询V值
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 根据K值修改Value值
     * @param key
     * @param newValue
     */
    void set(K key, V newValue);

    /**
     * 查看Map中的元素个数
     * @return
     */
    int getSize();

    /**
     * 查看Map是否为空
     * @return
     */
    boolean isEmpty();
}
