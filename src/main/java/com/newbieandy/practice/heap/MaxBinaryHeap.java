package com.newbieandy.practice.heap;

/**
 * 二叉堆(最大堆)
 *
 * @param <T>
 */
public class MaxBinaryHeap<T extends Comparable<? super T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private T[] array;

    public MaxBinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MaxBinaryHeap(int capacity) {
        this.currentSize = 0;
        this.array = (T[]) new Comparable[capacity + 1];
    }

    public MaxBinaryHeap(T[] items) {
        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (T item : items) {
            array[i++] = item;
        }
        buildHeap();
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
        for (; hole > 1 && t.compareTo(array[hole / 2]) > 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        //插入位置的节点
        array[hole] = t;
    }

    public T findMax() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return array[1];
    }

    public T deleteMax() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        T maxItem = findMax();
        //最后一个元素放到顶部
        array[1] = array[currentSize--];
        return null;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public void makeEmpty() {
        this.currentSize = 0;
    }


    /**
     * 下滤
     *
     * @param hole
     */
    private void percolateDown(int hole) {
        int child;
        T temp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            //left
            child = hole * 2;
            //左右孩子中找最大值
            if (child != currentSize && array[child + 1].compareTo(array[child]) > 0) {
                //right
                child++;
            }

            //孩子与目标值进行对比
            if (array[child].compareTo(temp) > 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = temp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
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
