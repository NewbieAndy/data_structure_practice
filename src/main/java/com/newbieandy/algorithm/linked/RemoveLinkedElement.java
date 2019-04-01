package com.newbieandy.algorithm.linked;

/**
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedElement {
    private static ListNode getLinkedList() {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        return listNode1;
    }

    private static ListNode rlement(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode l = head;
        while (l.next != null) {
            if (l.next.val == val) {

                l.next = l.next.next;
            } else {

                l = l.next;
            }
        }
        return head;

    }

    /**
     * 删除指定元素
     */
    private static ListNode removeElement(ListNode head, int val) {
        ListNode temp = null;
        while (head != null && head.val == val) {
            temp = head;
            head = head.next;
            temp.next = null;
            temp = null;
        }
        ListNode p = head;
        //非尾结点
        while (p != null && p.next != null) {
            if (null != p.next && p.next.val == val) {
                temp = p.next;
                p.next = p.next.next;
                temp.next = null;
                temp = null;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode linkedList = getLinkedList();
        LinkedUtil.printLinkedList(linkedList);
        ListNode listNode = removeElement(linkedList, 2);
        System.out.println("=======");
        LinkedUtil.printLinkedList(listNode);
        System.out.println("new");
//        ListNode listNode1 = rlement(linkedList, 2);
//        System.out.println("=======");
//        LinkedUtil.printLinkedList(listNode1);
    }
}
