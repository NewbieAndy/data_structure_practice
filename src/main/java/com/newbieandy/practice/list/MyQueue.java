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
        if (currentSize == theArray.length) {
            ensureCapacity(currentSize * 2 + 1);
        }
        theArray[tail++] = value;
        if (tail >= theArray.length) {
            tail = tail % theArray.length;
            System.out.println("入队当前🔢长度:" + theArray.length);
        }
        currentSize++;
    }

    //出队
    public T dequeue() {
        if (currentSize == 0) {
            throw new NoSuchElementException();
        }
        T t = theArray[head++];
        if (head >= theArray.length) {
            head = head % theArray.length;
            System.out.println("出队当前🔢长度:" + theArray.length);
        }
        currentSize--;
        return t;
    }

    public void ensureCapacity(int newCapacity) {
        if (currentSize > newCapacity) {
            return;
        }
        T[] oldArry = theArray;
        theArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < currentSize; i++) {
            theArray[i] = oldArry[i];
        }
    }
}
