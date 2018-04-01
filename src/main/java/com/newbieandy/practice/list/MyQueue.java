package com.newbieandy.practice.list;

import java.util.NoSuchElementException;

/**
 * Created by mchao on 2018/3/29.
 */
public class MyQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] theArray;
    //元素个数
    private int currentSize;
    //当前容量
    private int currentCapactiy;
    //头指针
    private int head;
    //尾指针
    private int tail;

    public MyQueue() {
        currentSize = 0;
        //头尾均指向0
        head = 0;
        tail = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    //入队
    public void enqueue(T value) {
        theArray[tail++] = value;
        currentSize++;
        //判断是否满了
        if (currentSize == currentCapactiy) {
            ensureCapacity(currentSize * 2 + 1);
        }
        if (tail >=currentCapactiy) {
            tail = tail % currentCapactiy;
        }
        currentSize++;
    }

    //出队
    public T dequeue() {
        if (currentSize == 0) {
            throw new NoSuchElementException();
        }
        T t = theArray[head++];
        if (head >=currentCapactiy) {
            head = head % currentCapactiy;
            System.out.println("当前head指针位置"+head);
            System.out.println("出队当前队列容量:" + currentCapactiy);
        }
        currentSize--;
        return t;
    }

    //扩容两种情况
    public void ensureCapacity(int newCapacity) {
        if (currentSize > newCapacity) {
            return;
        }
        currentCapactiy=newCapacity;
        T[] oldArry = theArray;
        theArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < currentSize; i++) {
            theArray[i] = oldArry[i];
        }
    }
}
