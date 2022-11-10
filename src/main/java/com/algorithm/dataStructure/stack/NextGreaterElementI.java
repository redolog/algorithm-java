package com.algorithm.dataStructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/next-greater-element-i/
 *
 * @author DragonSong  @date 2022/11/10
 */
public class NextGreaterElementI {

    /**
     * 时间：O(m+n)
     * 空间：O(n)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // nums2从右开始，看比当前下标以及更右 的最近最大元素
        Map<Integer, Integer> num2RightGreater = new HashMap<>();
        // 单调递增栈，栈中只维护当前最新的递增序列，栈顶最小
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];
            // 当前元素比更右的更大，更右入队的可以出队了
            while (!stk.isEmpty() && stk.peek() <= curr) {
                stk.pop();
            }
            // 记住答案要的是比当前元素右侧更大且更近的元素
            num2RightGreater.put(curr, stk.isEmpty() ? -1 : stk.peek());
            stk.push(curr);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = num2RightGreater.get(nums1[i]);
        }
        return ans;
    }
}
