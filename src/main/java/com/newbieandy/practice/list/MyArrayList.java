package com.newbieandy.practice.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mchao on 2018/3/28.
 */
public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T[] items;

    public MyArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public void trimToSize() {
        ensureCapacity(size());
    }

    public T get(int idx) {
        if (0 > idx || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[idx];
    }

    public T set(int idx, T value) {
        if (0 > idx || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //获取旧值
        T old = items[idx];
        //设置新值
        items[idx] = value;
        return old;
    }

    //默认在列表最后添加
    public void add(T value) {
        add(size(), value);
    }

    //指定位置添加元素
    public void add(int idx, T value) {
        if (size() == items.length) {
            //需要扩容
            ensureCapacity(size() * 2 + 1);
        }
        //遍历元素,指定位置后元素要进行向后进行位移
        for (int i = theSize; i > idx; i--) {
            items[i] = items[i - 1];
        }
        items[idx] = value;
        //长度+1
        theSize++;
    }

    public T remove(int idx) {
        //取出指定位置元素
        T removeItem = items[idx];
        //其他位置向前位移
        for (int i = idx; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        theSize--;
        return removeItem;
    }


    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        T[] old = items;
        //创建新数组
        items = (T[]) new Object[newCapacity];
        //老数据复制到新数组
        for (int i = 0; i < size(); i++) {
            items[i] = old[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {

        //当前坐标
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
