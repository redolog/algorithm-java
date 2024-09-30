package com.algorithm.dataStructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-ii/">503. 下一个更大元素 II</a>
 *
 * @author songhuilong  @date 2024/9/30
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        // 使用单调栈维护递减序列，当找到更大的元素时，持续的将小于当前元素的数据出栈
        Map<Integer, Integer> idx2NextGreater = new HashMap<>();
        int n = nums.length;

        // 单调栈中存的是下标，因为入参数组中会有重复元素，通过下标做区分
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stk.isEmpty() && num > nums[stk.peekLast()]) {
                idx2NextGreater.put(stk.pollLast(), num);
            }
            stk.offerLast(i % n);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = idx2NextGreater.getOrDefault(i, -1);
        }
        return ans;
    }
}
