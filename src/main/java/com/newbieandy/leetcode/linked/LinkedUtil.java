package com.newbieandy.leetcode.linked;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LinkedUtil {

    public static void printLinkedList(ListNode node) {
        while (Objects.nonNull(node)) {
            System.out.print(node.val);
            System.out.print("-->");
            node = node.next;
        }
    }

    public static ListNode getLinkedList(int[] arr) {
        List<ListNode> listNodeList = Arrays.stream(arr).mapToObj(i -> new ListNode(i)).collect(Collectors.toList());
        for (int i = 0; i < listNodeList.size() - 1; i++) {
            listNodeList.get(i).next = listNodeList.get(i + 1);
        }
        return listNodeList.get(0);
    }

    public static void main(String[] args) {
        ListNode listNode = getLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(listNode);
    }
}
