package com.algorithm.dataStructure.linkedList;

/**
 * https://leetcode.cn/problems/merge-in-between-linked-lists/
 *
 * @author songhuilong001  @date 2023/1/30
 */
public class MergeInBetweenLinkedList {

    public ListNode mergeInBetween(ListNode l1, int a, int b, ListNode l2) {
        // pre记录remove区间前驱节点；next记录remove区间后继节点；
        ListNode ans = l1, pre1 = null, next1 = null;
        for (int i = 0; i < b + 2; i++) {
            if (i == a - 1) {
                pre1 = l1;
            }
            if (i == b + 1) {
                next1 = l1;
            }
            l1 = l1.next;
        }

        ListNode start2 = l2, end2 = null;
        while (l2 != null) {
            end2 = l2;
            l2 = l2.next;
        }

        pre1.next = start2;
        end2.next = next1;

        return ans;
    }
}
