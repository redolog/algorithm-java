package com.algorithm.dp;

/**
 * https://leetcode.cn/problems/maximum-ascending-subarray-sum/
 *
 * @author DragonSong  @date 2022/10/7
 */
public class MaximumAscendingSubarraySum {

    /**
     * |   要素  |   |
     * |  ----  | ----  |
     * |  状态表示  | `dp[i]`表示`nums[i]`结尾的升序子数组和  |
     * |  阶段划分  | 出现降序则出现新的序列、阶段  |
     * |  转移方程  | `dp[i]= nums[i]>nums[i-1] ? dp[i-1]+nums[i] : nums[i]`  |
     * |  边界  | `dp[0]==nums[0]`，第一个元素自己构成一个升序子数组 |
     * |  目标  | `max(dp[i])` |
     * <p>
     * 同时由于转移方程当前值只与前序值有关，因此可利用滚动数组的技巧进行空间效率优化（dp数组改为只维护前序值prev）
     * <p>
     * 时间复杂度：完整遍历一次nums，O(n)
     * 空间复杂度：只维护了prev、sum，O(1)
     */
    public int maxAscendingSum(int[] nums) {
        // prev维护上一个元素（用于升序降序判断）；sum维护当前升序子数组和；ans取最大的sum；
        int prev = nums[0], sum = prev, ans = sum;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr > prev) {
                sum += curr;
                ans = Math.max(ans, sum);
            } else {
                sum = curr;
            }
            prev = curr;
        }
        return ans;
    }
}
