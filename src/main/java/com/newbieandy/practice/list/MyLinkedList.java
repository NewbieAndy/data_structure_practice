package com.newbieandy.practice.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mchao on 2018/3/28.
 */
public class MyLinkedList<T> implements Iterable {
    private int theSize;
    private int modCount = 0;
    //起始标记
    private Node<T> beginMarker;
    //结束标记
    private Node<T> endMarker;

    //构造函数
    public MyLinkedList() {
        clear();
    }

    //清空链表
    public void clear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return 0 == size();
    }

    //添加队尾
    public boolean add(T value) {
        add(size(), value);
        return true;
    }

    //指定位置添加元素
    public void add(int idx, T value) {
        addBefore(getNode(idx), value);
    }

    //获取指定位置数据
    public T get(int idx) {
        return getNode(idx).data;
    }

    //设置当前位置数据
    public T set(int idx, T value) {
        //获取当前位置节点
        Node<T> node = getNode(idx);
        //获取当前位置数据
        T oldData = node.data;
        node.data = value;
        return oldData;
    }

    public T remove(int idx) {
        return remove(getNode(idx));
    }

    //指定节点前添加元素
    private void addBefore(Node<T> p, T value) {
        //创建节点,新节点的next指向老节点,新节点的prve指向老节点的prve
        Node<T> newNode = new Node<T>(value, p.prve, p);
        //老节点的next指向新节点
        p.prve.next = newNode;
        p.prve = newNode;
        theSize++;
        modCount++;
    }

    //移除节点
    private T remove(Node<T> p) {
        //当前节点的前一个元素指向当前节点的后一个元素
        p.prve.next = p.next;
        //当前节点的后一个元素指向当前节点的前一个元素
        p.next.prve = p.prve;
        theSize--;
        modCount++;
        return p.data;
    }

    //获取指定索引处的节点
    private Node<T> getNode(int idx) {
        Node<T> p;
        if (0 > idx || size() < idx) {
            throw new IndexOutOfBoundsException();
        }
        //判断从头开始还是从尾开始
        if (idx < size() / 2) {
            //从头开始
            p = beginMarker.next;
            //遍历链表
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prve;
            }
        }
        return p;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    //节点定义
    private static class Node<T> {
        public T data;
        public Node<T> prve;
        public Node<T> next;

        public Node(T data, Node<T> prve, Node<T> next) {
            this.data = data;
            this.prve = prve;
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prve);
            okToRemove = false;
            expectedModCount++;
        }
    }
}
