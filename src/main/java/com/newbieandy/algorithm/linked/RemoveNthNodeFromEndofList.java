package com.newbieandy.algorithm.linked;

/**
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * @author chao.ma
 * @Date 2019/4/3 16:31
 * @Version 1.0
 */
public class RemoveNthNodeFromEndofList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer = head;
        for (int i = 0; i < n; i++) {
            pointer = pointer.next;
        }
        if (pointer == null) {
            //头结点为要删除的节点
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }

        pointer = pointer.next;
        if (pointer == null) {
            //第二个节点为删除节点
            ListNode deleteNode = head.next;
            head.next = deleteNode.next;
            deleteNode.next = null;
            return head;
        }
        ListNode deletePreNode = head;
        while (true) {
            pointer = pointer.next;
            deletePreNode = deletePreNode.next;
            if (pointer == null) {
                ListNode deleteNode = deletePreNode.next;
                deletePreNode.next = deleteNode.next;
                deleteNode.next = null;
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = LinkedUtil.getLinkedList(new int[]{1, 2});
        ListNode fromEnd = removeNthFromEnd(listNode, 1);
        System.out.println(fromEnd);
    }
}
