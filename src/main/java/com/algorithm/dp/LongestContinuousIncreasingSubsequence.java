package com.algorithm.dp;

/**
 * 674. Longest Continuous Increasing Subsequence
 * Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.
 * <p>
 * A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
 * Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
 * 4.
 * Example 2:
 * <p>
 * Input: nums = [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
 * increasing.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
 *
 * @author dragonsong  @date 2022/8/4
 */
public class LongestContinuousIncreasingSubsequence {

    static class NativeDP {
        /*
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 99.91%
         * 的用户
         * 内存消耗：
         * 42 MB
         * , 在所有 Java 提交中击败了
         * 42.20%
         * 的用户
         * 通过测试用例：
         * 35 / 35
         */

        /**
         * |  LCS问题要素  |   |
         * |  ----  | ----  |
         * |  状态表示  | `dp[i]`表示`nums[i]`结尾的LCIS长度；  |
         * |  阶段划分  | 已处理的前缀串，对应数组位置 nums[i]；  |
         * |  转移方程  | `dp[i]= nums[i]>nums[i-1] ? dp[i-1]+1 : 1` |
         * |  边界  | `dp[0]==1` |
         * |  目标  | `max(dp[i]) 0<=i<n` |
         */
        public int findLengthOfLCIS(int[] nums) {
            int ans = 1;
            int n = nums.length;
            // dp
            int prevDp = 1;
            for (int i = 1; i < n; i++) {
                prevDp = nums[i] > nums[i - 1] ? prevDp + 1 : 1;
                ans = Math.max(ans, prevDp);
            }
            return ans;
        }
    }

}
