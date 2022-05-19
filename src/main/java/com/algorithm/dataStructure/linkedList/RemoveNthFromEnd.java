package com.algorithm.dataStructure.linkedList;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * 进阶：能尝试使用一趟扫描实现吗？
 * <p>
 * https://leetcode.cn/problems/SLwz0R/
 *
 * @author dragonsong  @date 2022/5/19
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEndTwoPointer(ListNode head, int n) {
        // 双指针的思路：慢指针下标+n == 快指针的下标

        ListNode slow = head;
        ListNode fast = head;

        // fast先走个n的步长
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 边界
        if (fast == null) {
            // 说明删的是head节点
            return head.next;
        }

        // 之后fast/slow 同频走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 只要n>=1，此时slow就不会npe
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode removeNthFromEndCalcLen(ListNode head, int n) {
        int len = 0;
        ListNode current = head;
        while (current != null) {
            ++len;
            current = current.next;
        }

        if (n == len) {
            return head.next;
        }

        // 经过一次遍历得出链表长度后，又已知n，可以得到删除节点、prev节点的遍历下标
        // prev 下标为 len-n-1
        int idx = 0;
        current = head;
        while (current != null) {
            if (idx == len - n - 1) {
                current.next = current.next.next;
                break;
            }
            ++idx;
            current = current.next;

        }
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 使用栈结构存链表节点
        Deque<ListNode> nodeStack = new LinkedList<>();

        ListNode dummyHead = new ListNode(-1, head);

        ListNode current = head;
        while (current != null) {
            nodeStack.push(current);
            current = current.next;
        }

        ListNode pre = null;
        ListNode next = null;
        while (!nodeStack.isEmpty() && n >= -1) {
            ListNode node = nodeStack.pop();
            --n;

            if (n == 1) {
                next = node;
            }
            if (n == -1) {
                pre = node;
            }
        }
        if (pre == null) {
            // 说明链表长度正好为n
            dummyHead.next = next;
        } else {
            pre.next = next;
        }

        return dummyHead.next;
    }

    public static ListNode removeNthFromEndStack2(ListNode head, int n) {
        // 使用栈结构存链表节点
        Deque<ListNode> nodeStack = new LinkedList<>();

        ListNode dummyHead = new ListNode(-1, head);

        ListNode current = head;
        while (current != null) {
            nodeStack.push(current);
            current = current.next;
        }

        while (!nodeStack.isEmpty() && n > 1) {
            nodeStack.pop();
            --n;
        }
        ListNode deleteNode = nodeStack.pop();
        ListNode prev = nodeStack.peek();
        if (prev == null) {
            // 说明链表长度正好为n
            dummyHead.next = deleteNode.next;
        } else {
            prev.next = prev.next.next;
        }

        return dummyHead.next;
    }
}

