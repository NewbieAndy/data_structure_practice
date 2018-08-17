package com.newbieandy.practice.heap;

/**
 * 二叉堆(最大堆)
 *
 * @param <T>
 */
public class BinaryHeap<T extends Comparable<? super T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private T[] array;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        this.currentSize = 0;
        this.array = (T[]) new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] items) {

    }

    public void insert(T t) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 - 1);
        }
        //percolate up 上滤
        //扩展占位符,比较其值是否比父节点大
        //把要插入的数据放入哨兵位置
        //如果新位置非根,且比其父节点大,则进行挪位
        //循环结束插入位置已经腾空出来,在进行赋值
        int hole = ++currentSize;
        for (array[0] = t; hole > 1 && t.compareTo(array[hole / 2]) > 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        //插入位置的节点
        array[hole] = t;
    }

    public T findMin() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return array[1];
    }

    public T deleteMin() {
        return null;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public void makeEmpty() {
        this.currentSize = 0;
    }


    private void percolateDown(int hole) {

    }

    private void buildHeap() {

    }

    private void enlargeArray(int newSize) {
        T[] old = this.array;
        //create new array
        this.array = (T[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            this.array[i] = old[i];
        }
    }


}
