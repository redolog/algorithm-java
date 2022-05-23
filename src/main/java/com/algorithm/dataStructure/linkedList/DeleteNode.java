package com.algorithm.dataStructure.linkedList;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * <p>
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @author dragonsong  @date 2022/5/19
 */
public class DeleteNode {

    public static ListNode deleteNodeTwoPointer(ListNode head, int val) {
        ListNode current = head, pre = null;
        while (current != null) {
            if (current.val == val) {
                if (pre == null) {
                    // 删除内容命中head节点
                    return head.next;
                }
                // 删除current节点
                pre.next = current.next;
            }
            pre = current;
            current = current.next;
        }

        return head;
    }

    /**
     * 使用 current 单个指针节省内存
     */
    public static ListNode deleteNodeSinglePointer(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }

        ListNode current = head;
        while (current.next.val != val) {
            current = current.next;
        }

        current.next = current.next.next;
        return head;
    }
}
