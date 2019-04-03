package com.newbieandy.algorithm.linked;

/**
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * @author chao.ma
 * @Date 2019/4/3 16:33
 * @Version 1.0
 */
public class MiddleOfTheLinkedList {

    public static ListNode middleNode(ListNode head) {
        ListNode slower = head;
        ListNode faster = head;

        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }
        return slower;
    }

    public static void main(String[] args) {
        ListNode listNode = LinkedUtil.getLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode middleNode = middleNode(listNode);
        System.out.println(middleNode);
        ListNode listNode1 = LinkedUtil.getLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode middleNode1 = middleNode(listNode1);
        System.out.println(middleNode1);
    }
}
