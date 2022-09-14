package com.algorithm.dataStructure.linkedList;

/**
 * https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/
 *
 * @author songhuilong  @date 2022/9/14
 */
public class KthNodeFromEndOfListLcci {

    public int kthToLast(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), slow = dummy, fast = dummy;
        int fastStep = 0;
        while (fast != null && fastStep < k) {
            fast = fast.next;
            fastStep++;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}
