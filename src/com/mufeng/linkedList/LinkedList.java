package com.mufeng.linkedList;

/**
 * Created by wb-yxk397023 on 2018/6/19.
 */
public class LinkedList<E> {

    /**
     * 声明内部类
     */
    private class Node{

        // 要存储的元素
        public E e;
        // 声明指针(指向下一个元素位置)
        public Node next;

        // 有参构造器
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        // 重载构造器
        public Node(E e){
            this(e, null);
        }

        // 重载构造器
        public Node(){
            this(null, null);
        }

        /**
         * toString
         * @return
         */
        @Override
        public String toString(){
            return e.toString();
        }
    }

    // 链表头元素
    private Node dummyHead;
    // 链表元素个数
    private int size;

    // 构造函数
    public LinkedList(){
        // 默认初始值为null
        dummyHead = new Node();
        // 默认元素个数为0
        size = 0;
    }

    // 获取链表中元素的个数
    public int getSize(){
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e(此功能不常用)
    public void add(E e, int index){
        // 判断index是否合法
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        // 通过遍历找到要添加节点的前一个节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);

        // 维护size属性
        size++;

    }

    // 在链表头添加新的元素e
    public void addFrist(E e){
        add(e,0);
    }

    // 在链表的尾部添加元素
    public void addLast(E e){
        add(e, size);
    }

    /**
     * 获得链表的第index(0-based)个位置的元素,在链表中不是一个常用的操作.
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    // 获取链表中的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获取链表中的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e,在链表中不是一个常用的操作.
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查询链表中是否存在元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;

        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除index(0-based)位置的元素, 返回删除的元素(在链表中不是一个常用的操作)
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    /**
     * 从链表中删除第一个元素
     * @return
     */
    public E removeFrist(){
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;

        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}
