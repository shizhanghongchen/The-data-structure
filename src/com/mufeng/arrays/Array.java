package com.mufeng.arrays;

/**
 * Created by yangxiaokai on 2018/5/27.
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        // 创建数组，长度为capacity
        data = (E[])new Object[capacity];
        // 长度为0
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array(){
        // 默认数组长度为10
        this(10);
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 在所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在index索引的位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        // 判断索引是不是合法
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        // 判断当前长度是不是大于数组长度,如果大于则进行扩容的逻辑
        if (size >= data.length){
            // 执行扩容
            resize(2 * data.length);
        }
        // 通过遍历将数组中的元素进行位移
        for (int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        // 将新添加的元素放入到数组指定的索引位置上
        data[index] = e;
        // 操作数组长度增加1
        size++;
    }

    /**
     * 获取索引index上的元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed, index is illegal.");
        }
        return data[index];
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getFrist(){
        return get(0);
    }
    /**
     * 设置索引index上的元素
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed, index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查询数组中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        // 遍历数组查找元素
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        // 遍历数组查找元素
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
                // 返回索引
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed, index is illegal.");
        }
        // 记录被删除的元素
        E res = data[index];
        // 通过遍历将数组中的元素进行位移
        for (int i = index + 1; i < size; i++){
            // 索引靠后的元素覆盖索引靠前的元素
            data[i - 1] = data[i];
        }
        // 操作数组长度
        size--;
        // 将size位置上的元素置空
        data[size] = null;
        // 执行缩容
        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        // 返回记录结果
        return res;
    }

    /**
     * 从数组中删除第一个索引上的元素并返回被删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个索引上的元素并返回被删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 从数组中删除指定元素
     * @param e
     */
    public void removeElement(E e){
        // 查询数组中是否有此元素
        int index = find(e);
        // 根据结果判断
        if (index != -1){
            remove(index);
        }
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString(){
        // 创建新的容器
        StringBuilder builder = new StringBuilder();
        // 设置数组格式
        builder.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        // 拼接返回值
        builder.append("[");
        for (int i = 0; i < size; i++){
            // 向容器中添加元素
            builder.append(data[i]);
            // 判断是否大于容器长度
            if (i != size -1){
                // 拼接分隔符
                builder.append(", ");
            }
        }
        // 闭合
        builder.append("]");
        // 返回
        return builder.toString();
    }

    /**
     * 动态逻辑(操作容器大小)
     * @param newCapacity
     */
    private void resize(int newCapacity){
        // 创建新的容器
        E[] newData = (E[]) new Object[newCapacity];
        // 数据迁移
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        // 改变引用
        data = newData;
    }
}
