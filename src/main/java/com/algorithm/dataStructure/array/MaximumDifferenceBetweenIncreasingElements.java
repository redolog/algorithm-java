package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/maximum-difference-between-increasing-elements/
 *
 * @author songhuilong  @date 2022/11/2
 */
public class MaximumDifferenceBetweenIncreasingElements {

    /**
     * 逐个遍历，维护一个左侧更小值，如果当前值比更小值更大，那么计算他们的差，同时维护一个最大的ans
     * 时间：O(n)
     * 空间：O(1)
     */
    public int maximumDifference(int[] nums) {
        int n = nums.length, i = 1, leftMin = nums[0], ans = -1;
        for (; i < n; i++) {
            if (nums[i] <= leftMin) {
                leftMin = nums[i];
            } else {
                ans = Math.max(ans, nums[i] - leftMin);
            }
        }
        return ans;
    }
}
