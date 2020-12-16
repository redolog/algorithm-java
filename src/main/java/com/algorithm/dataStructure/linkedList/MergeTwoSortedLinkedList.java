package com.algorithm.dataStructure.linkedList;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 * @author DragonSong  @date 2020/12/16
 */
public class MergeTwoSortedLinkedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return traverse(l1, l2);
    }

    private ListNode traverse(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cursor = new ListNode(-1);
        ListNode head = cursor;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cursor.next = l2;
                break;
            }
            if (l2 == null) {
                cursor.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                cursor.next = l1;
                l1 = l1.next;
            } else {
                cursor.next = l2;
                l2 = l2.next;
            }
            cursor = cursor.next;
        }
        return head.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
