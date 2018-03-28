package com.newbieandy.practice.list;

import java.util.NoSuchElementException;

/**
 * Created by mchao on 2018/3/28.
 */
public class MyStack<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T[] theArray;
    private int topOfStack;

    public MyStack() {
        theSize = 0;
        topOfStack = -1;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    //压栈
    public void push(T value) {
        if (topOfStack > size() - 1) {
            ensureCapacity(2 * size() + 1);
        }
        theArray[++topOfStack] = value;
        theSize++;
    }

    public T peek() {
        if (topOfStack == -1) {
            throw new NoSuchElementException();
        }
        return theArray[topOfStack];
    }

    //出栈
    public T pop() {
        if (topOfStack == -1) {
            throw new NoSuchElementException();
        }
        T t = theArray[topOfStack--];
        theSize--;
        return t;
    }


    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theArray;
        //创建新数组
        theArray = (T[]) new Object[newCapacity];
        //老数据复制到新数组
        for (int i = 0; i < size(); i++) {
            theArray[i] = old[i];
        }
    }

}
