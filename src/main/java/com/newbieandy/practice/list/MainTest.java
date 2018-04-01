package com.newbieandy.practice.list;

import java.util.Iterator;

/**
 * Created by mchao on 2018/3/26.
 */
public class MainTest {
    public static void main(String[] args) {
//        myArrayListTest();
//        myLinkedListTest();
//        myStackTest();
//        bracketTest();
        myQueueTest();
//        bracketTest();
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

    public static void myStackTest() {
        MyStack<Integer> stack = new MyStack<Integer>();
        System.out.println(stack.size());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    //校验代码括号
    private static void bracketTest() {
        String code = "System.out.println (stack.pop())";
        MyStack<Character> codeStack = new MyStack();
        char[] chars = code.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '{' || aChar == '(' || aChar == '[') {
                codeStack.push(aChar);
            }
            if (aChar == '}' || aChar == ')' || aChar == ']') {
                if (codeStack.isEmpty()) {
                    System.out.println("缺少符号:" + getMappingChar(aChar));
                }
                Character popChar = codeStack.pop();
                if (!(aChar == getMappingChar(popChar))) {
                    System.out.println("符号:" + aChar + "与符号:" + popChar + "不对应");
                }
            }
        }
        if (!codeStack.isEmpty()) {
            System.out.println("代码缺少括号");
        } else {
            System.out.println("代码没问题");
        }
    }

    private static char getMappingChar(char achar) {
        switch (achar) {
            case '[':
                return ']';
            case ']':
                return '[';
            case '(':
                return ')';
            case ')':
                return '(';
            case '{':
                return '}';
            case '}':
                return '{';
        }
        return achar;
    }


    private static void myQueueTest() {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        myQueue.enqueue(7);
        myQueue.enqueue(8);
        myQueue.enqueue(9);
        myQueue.enqueue(10);
        myQueue.enqueue(11);
        myQueue.enqueue(12);
        myQueue.enqueue(13);
        myQueue.enqueue(14);
        myQueue.enqueue(15);
        for (int i = 0; i < 5; i++) {
            System.out.println(myQueue.dequeue());
        }
        myQueue.enqueue(11);
        myQueue.enqueue(12);
        myQueue.enqueue(13);
        myQueue.enqueue(14);
        myQueue.enqueue(15);

        for (int i = 0; i < 15; i++) {
            System.out.println(myQueue.dequeue());
        }
    }
}
