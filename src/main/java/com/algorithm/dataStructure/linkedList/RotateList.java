package com.algorithm.dataStructure.linkedList;

/**
 * https://leetcode.cn/problems/rotate-list/
 *
 * @author songhuilong  @date 2025/11/19
 */
public class RotateList {

    // 原尾节点
    ListNode tail;

    public ListNode rotateRight(ListNode head, int k) {
        // 算法概述：设链表长度为n，给定k，先对n取模，k%n 为实际需要挪动的节点数量。
        // 1. 计算n，k%n、n-k%n值；
        // 2. 正向遍历，找三个节点：
        // 2.1 找到第 n-k%n 个节点，表示旋转后的链表尾；
        // 2.2 其.next为旋转后的链表头；
        // 2.3 原链表尾拼接到原链表头；
        tail = null;
        int n = calcLen(head);
        if (n == 0) {
            return head;
        }
        k = k % n;
        if (k == 0) {
            return head;
        }
        ListNode newTail = findNewTail(n, k, head);

        ListNode newHead = newTail.next;
        tail.next = head;
        newTail.next = null;
        return newHead;
    }

    private ListNode findNewTail(int n, int k, ListNode head) {
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            i++;
            if (i == n - k) {
                break;
            }
            curr = curr.next;
        }
        return curr;
    }

    private int calcLen(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            n++;
            prev = curr;
            curr = curr.next;
        }
        tail = prev;
        return n;
    }
}
