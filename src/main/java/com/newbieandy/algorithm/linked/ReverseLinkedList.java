package com.newbieandy.algorithm.linked;

import java.util.Objects;

public class ReverseLinkedList {
    private static ListNode getLinkedList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        return listNode1;
    }

    private static ListNode reverseLinedList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        //当前结点的前置结点
        ListNode pre = null;
        while (null != head) {
            //保存当前结点的下一个结点
            ListNode temp = head.next;
            //更新当前结点的下一个结点为前置结点
            head.next = pre;
            //更新前置结点
            pre = head;
            //移动当前结点指针
            head = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode linkedList = getLinkedList();
        LinkedUtil.printLinkedList(linkedList);
        ListNode listNode = reverseLinedList(linkedList);
        System.out.println("=====");
        LinkedUtil.printLinkedList(listNode);
    }
}
