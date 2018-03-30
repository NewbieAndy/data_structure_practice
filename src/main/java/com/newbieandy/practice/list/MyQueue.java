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
        if (currentSize == currentCapactiy) {
            ensureCapacity(currentSize * 2 + 1);
        }
        theArray[tail++] = value;
        if (tail >= currentCapactiy) {
            tail = tail % currentCapactiy;
            System.out.println("当前tail指针位置" + tail);
            System.out.println("入队当前队列容量:" + currentCapactiy);
        }
        currentSize++;
    }

    //出队
    public T dequeue() {
        if (currentSize == 0) {
            throw new NoSuchElementException();
        }
        T t = theArray[head++];
        if (head >= currentCapactiy) {
            head = head % currentCapactiy;
            System.out.println("当前head指针位置" + head);
            System.out.println("出队当前队列容量:" + currentCapactiy);
        }
        currentSize--;
        return t;
    }

    private void ensureCapacity(int newCapacity) {
        if (currentSize > newCapacity) {
            return;
        }
        int oldCapacity = currentCapactiy;
        currentCapactiy = newCapacity;
        T[] oldArry = theArray;
        theArray = (T[]) new Object[newCapacity];
        if (newCapacity == DEFAULT_CAPACITY || (head == 0 && tail == 0)) {
            for (int i = 0; i < currentSize; i++) {
                theArray[i] = oldArry[i];
            }
        } else {
            int oldArryIdx = 0;
            for (int i = 0; i < currentSize; i++) {
                oldArryIdx = head + i;
                if (oldArryIdx >= currentSize) {
                    oldArryIdx = oldArryIdx - currentSize;
                }
                theArray[i] = oldArry[oldArryIdx];
            }
        }
        if (currentSize > 0 && currentSize == oldCapacity) {
            head = 0;
            tail = currentSize - 1;
        }
    }
}
