package com.newbieandy.leetcode.linked;

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int over = 0;
        ListNode result = null;
        ListNode resultTail = null;
        while (over != 0 || l1 != null || l2 != null) {
            //linked1 val
            int x = 0;
            //linked2 val
            int y = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }
            int z = x + y + over;
            over = z / 10;
            int r = z % 10;
            ListNode node = new ListNode(r);
            if (result == null) {
                result = node;
                resultTail = result;
            } else {
                resultTail.next = node;
                resultTail = resultTail.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedUtil.getLinkedList(new int[]{2, 4, 3});
        ListNode l2 = LinkedUtil.getLinkedList(new int[]{5, 6, 4});
        ListNode listNode = addTwoNumbers(l1, l2);
        LinkedUtil.printLinkedList(listNode);
    }
}
