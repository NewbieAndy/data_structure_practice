package com.newbieandy.practice.list;

import java.util.Iterator;

/**
 * Created by mchao on 2018/3/26.
 */
public class MainTest {
    public static void main(String[] args) {
        myArrayListTest();
        myLinkedListTest();
    }

    public static void myArrayListTest() {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.size());
        list.set(0, 2);
        System.out.println(list.get(0));
        list.clear();
        System.out.println(list.size());
    }

    public static void myLinkedListTest() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(4);
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
