package com.algorithm.dataStructure.linkedList;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/linked-list-components/
 *
 * @author songhuilong  @date 2022/10/12
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        // prev用来存链表遍历上一个值
        int ans = 0, prev = -1;
        ListNode curr = head;
        while (curr != null) {
            if (!numSet.contains(prev) && numSet.contains(curr.val)) {
                ans++;
            }
            prev = curr.val;
            curr = curr.next;
        }
        return ans;
    }
}
