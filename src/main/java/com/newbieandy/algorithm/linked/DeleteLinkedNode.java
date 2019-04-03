package com.newbieandy.algorithm.linked;

import java.util.Objects;

public class DeleteLinkedNode {
    private static ListNode getLinkedList() {
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode9 = new ListNode(9);
        listNode4.next = listNode5;
        listNode5.next = listNode1;
        listNode1.next = listNode9;
        return listNode4;
    }

    private static void delete(ListNode node, int val) {
        while (Objects.nonNull(node)) {
            if (node.val == val) {
                if (Objects.nonNull(node.next)) {
                    //非尾部节点
                    node.val = node.next.val;
                    node.next = node.next.next;
                } else {
                    //尾部节点
                }
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode list = getLinkedList();
        LinkedUtil.printLinkedList(list);
        delete(list, 4);
        System.out.println("=======");
        LinkedUtil.printLinkedList(list);
    }
}
