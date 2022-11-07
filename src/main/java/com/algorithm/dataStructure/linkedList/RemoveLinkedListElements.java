package com.algorithm.dataStructure.linkedList;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 *
 * @author DragonSong  @date 2022/11/7
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        // 删到只剩最后一个节点，并且与val相等
        if (prev.val == val) {
            return null;
        }
        return dummy.next;
    }

}
