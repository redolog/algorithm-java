package com.algorithm.dataStructure.linkedList.monotonous;

import com.algorithm.dataStructure.linkedList.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/next-greater-node-in-linked-list/
 *
 * @author songhuilong001  @date 2023/4/10
 */
public class NextGreaterNodeInLinkedList {

    /**
     * 从右往左遍历链表节点：
     * 1. 维护一个单调递减栈；
     * 2. 栈顶为最小值；
     * 3. 栈底为最大值；
     * 4. 栈顶值小于等于当前值时（即当前栈顶不是当前值的右侧头一个更大值），出栈，一直到栈空，或者栈顶值大于当前值（此时栈顶为当前值的ans[i]）；
     */
    public int[] nextLargerNodes(ListNode head) {
        // 记录链表数据
        Deque<Integer> deque = new ArrayDeque<>();
        ListNode curr = head;
        while (curr != null) {
            deque.offerFirst(curr.val);
            curr = curr.next;
        }
        // 单调递减栈
        Deque<Integer> monotonousStk = new ArrayDeque<>();
        // 链表最右侧答案为0
        monotonousStk.push(0);
        int n = deque.size();
        int[] ans = new int[n];
        int i = n - 1;
        while (deque.size() > 0) {
            Integer currVal = deque.pollFirst();
            while (!monotonousStk.isEmpty() && monotonousStk.peek() <= currVal) {
                monotonousStk.pop();
            }
            ans[i--] = monotonousStk.isEmpty() ? 0 : monotonousStk.peek();
            monotonousStk.push(currVal);
        }
        return ans;
    }
}
