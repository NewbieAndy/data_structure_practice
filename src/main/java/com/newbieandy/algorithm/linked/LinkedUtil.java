package com.newbieandy.algorithm.linked;

import java.util.Objects;

public class LinkedUtil {

    public static void printLinkedList(ListNode node) {
        while (Objects.nonNull(node)) {
            System.out.print(node.val);
            System.out.print("-->");
            node = node.next;
        }
    }

}
