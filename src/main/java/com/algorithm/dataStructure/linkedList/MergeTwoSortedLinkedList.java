package com.algorithm.dataStructure.linkedList;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * @author dragonsong  @date 2022/5/19
 */
public class MergeTwoSortedLinkedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode current;
        if (l1.val > l2.val) {
            current = l2;
            l2 = l2.next;
        } else {
            current = l1;
            l1 = l1.next;
        }
        ListNode dummyHead = new ListNode(-1, current);

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                current = current.next = l2;
                l2 = l2.next;
            } else {
                current = current.next = l1;
                l1 = l1.next;
            }
        }

        current.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyHead = new ListNode();
        ListNode prev=dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev = prev.next = l2;
                l2 = l2.next;
            } else {
                prev = prev.next = l1;
                l1 = l1.next;
            }
        }

        prev.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }

}

