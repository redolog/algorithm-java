package com.algorithm.dataStructure.linkedList;

/**
 * https://leetcode.cn/problems/partition-list/
 *
 * @author songhuilong  @date 2025/11/19
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        // 算法概述：使用两个链表维护x分割的节点，最后拼接两条链表。
        ListNode biggerOrEqualDummy = new ListNode(-1);
        ListNode biggerOrEqualCurr = biggerOrEqualDummy;
        ListNode smallDummy = new ListNode(-1);
        ListNode smallCurr = smallDummy;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                smallCurr.next = curr;
                smallCurr = smallCurr.next;
            } else {
                biggerOrEqualCurr.next = curr;
                biggerOrEqualCurr = biggerOrEqualCurr.next;
            }
            curr = curr.next;
        }
        smallCurr.next = biggerOrEqualDummy.next;
        // 切断原节点后续指针
        biggerOrEqualCurr.next = null;

        return smallDummy.next;
    }
}
