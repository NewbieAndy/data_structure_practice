package com.newbieandy.algorithm.linked;

/**
 * 合并两个有序链表
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    private static ListNode getLinkedList1() {
        ListNode listNode1 = new ListNode(-10);
        ListNode listNode2 = new ListNode(-9);
        ListNode listNode3 = new ListNode(-6);
        ListNode listNode4 = new ListNode(-4);
        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
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

    private static ListNode mergeLinkedList(ListNode list1Head, ListNode list2Head) {
        ListNode newList = null;
        ListNode mainListHead = null;
        ListNode selectHead = null;
        ListNode selectTail = null;
        if (list1Head == null || list2Head == null) {
            return list1Head == null ? list2Head : list1Head;
        }
        //选择主链表
        if (list1Head.val <= list2Head.val) {
            newList = list1Head;
            selectHead = list2Head;
        } else {
            selectHead = list1Head;
            newList = list2Head;
        }
        mainListHead = newList;
        while (selectHead != null) {
            selectTail = selectHead;
            //查找主链表插入点
            while (mainListHead.next != null
                    && mainListHead.val <= selectHead.val
                    && selectHead.val >= mainListHead.next.val) {
                mainListHead = mainListHead.next;
            }
            //第二个链表接到第一个链表后
            if (mainListHead.next == null) {
                mainListHead.next = selectHead;
                selectHead = null;
            } else {
                //找到了插入点,找另一个链表结束结点
                while (selectTail.next != null
                        && selectTail.next.val >= mainListHead.val
                        && selectTail.next.val <= mainListHead.next.val) {
                    selectTail = selectTail.next;
                }
                ListNode mainNextTemp = mainListHead.next;
                ListNode selectTailNextTemp = selectTail.next;
                mainListHead.next = selectHead;
                selectHead = selectTailNextTemp;
                selectTail.next = mainNextTemp;
                mainListHead = mainNextTemp;
            }
        }

        return newList;
    }


    public static void main(String[] args) {
        /**
         * [-10,-9,-6,-4,1,9,9]
         * [-5,-3,0,7,8,8]
         */
        ListNode linkedList1 = getLinkedList1();
        ListNode linkedList2 = getLinkedList2();
        LinkedUtil.printLinkedList(linkedList1);
        System.out.println("=======");
        LinkedUtil.printLinkedList(linkedList2);
        ListNode mergeLinkedList = mergeLinkedList(linkedList1, linkedList2);
        System.out.println("===合并后链表====");
        LinkedUtil.printLinkedList(mergeLinkedList);
        System.out.println("===单结点====");
        LinkedUtil.printLinkedList(mergeLinkedList(new ListNode(2), new ListNode(1)));
    }
}
