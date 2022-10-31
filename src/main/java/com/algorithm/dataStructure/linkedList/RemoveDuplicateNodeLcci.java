package com.algorithm.dataStructure.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/remove-duplicate-node-lcci/
 *
 * @author songhuilong  @date 2022/10/31
 */
public class RemoveDuplicateNodeLcci {

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode curr = head, prev = new ListNode(-1);
        prev.next = curr;
        while (curr != null) {
            int val = curr.val;
            if (set.contains(val)) {
                // 当前node多次出现，删除
                prev.next = curr.next;
            } else {
                set.add(val);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
