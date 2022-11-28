package com.algorithm.dataStructure.linkedList;

/**
 * https://leetcode.cn/problems/sum-lists-lcci/
 *
 * @author songhuilong001  @date 2022/11/28
 */
public class SumListsLcci {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(), curr = dummy;
        int sum = 0, carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            if (carry == 1) {
                sum += 1;
                carry = 0;
            }
            if (sum > 9) {
                carry = 1;
                curr.next = new ListNode(sum - 10);
            } else {
                curr.next = new ListNode(sum);
            }
            curr = curr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            sum = 0;
        }
        if (carry == 1) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
    }
}
