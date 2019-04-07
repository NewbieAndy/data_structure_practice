package com.newbieandy.leetcode.linked;


public class LinkedListCycle {

    private static ListNode getLinkedList1() {
        ListNode listNode1 = new ListNode(10);
        ListNode listNode2 = new ListNode(7);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode3;
        return listNode1;
    }

    private static ListNode getLinkedList2() {
        //         * [-5,-3,0,7,8,8]
        ListNode listNode1 = new ListNode(-5);
        ListNode listNode2 = new ListNode(-3);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(7);
        ListNode listNode5 = new ListNode(8);
        ListNode listNode6 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        return listNode1;
    }

    private static ListNode getLinkedList3() {
        ListNode listNode1 = new ListNode(-5);
        ListNode listNode2 = new ListNode(-3);
        listNode1.next = listNode2;
        listNode2.next = listNode1;
        return listNode1;
    }

    private static boolean hasCycle(ListNode head) {
        ListNode slower = head;
        ListNode faster = head;
        while (faster != null && faster.next != null) {
            //需要先走出去再比较
            slower = slower.next;
            faster = faster.next.next;
            if (faster == slower) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode list1 = getLinkedList1();
        ListNode list2 = getLinkedList2();
        System.out.println("list1:" + hasCycle(list1));
        System.out.println("list2:" + hasCycle(list2));
        System.out.println("list3:" + hasCycle(getLinkedList3()));
    }

}
