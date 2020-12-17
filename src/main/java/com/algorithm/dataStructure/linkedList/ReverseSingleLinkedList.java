package com.algorithm.dataStructure.linkedList;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author DragonSong  @date 2020/12/17
 * @link {https://leetcode-cn.com/problems/reverse-linked-list/}
 */
public class ReverseSingleLinkedList {

    public ListNode reverseList(ListNode head) {
        return traverse(head);
    }

    private ListNode traverse(ListNode head) {
        // 上一个节点
        ListNode prev = null;
        // 下一个节点
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

