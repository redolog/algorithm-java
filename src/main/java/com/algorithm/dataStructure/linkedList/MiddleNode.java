package com.algorithm.dataStructure.linkedList;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定链表的结点数介于 1 和 100 之间。
 * <p>
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 *
 * @author dragonsong  @date 2022/5/19
 */
public class MiddleNode {

    public static ListNode middleNodeTwoPointer(ListNode head) {
        // 双指针，慢指针步长为1，快指针步长为2
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow :slow.next;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode current = head;
        int len = 0;
        while (current != null) {
            current = current.next;
            ++len;
        }

        int middle = len / 2 + 1;
        current = new ListNode(-1, head);

        for (int i = 0; i < middle; i++) {
            current = current.next;
        }

        return current;
    }
}
