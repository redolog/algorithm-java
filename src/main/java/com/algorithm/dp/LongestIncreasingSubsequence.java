package com.algorithm.dp;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * <p>
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 *
 * @author dragonsong  @date 2022/7/13
 */
public class LongestIncreasingSubsequence {

    static class DP {
        /**
         * dp[i]定位以 nums[i] 元素结尾的子序列，严格递增最长长度
         * 以 nums[i] 元素结尾时，子问题无后效性
         * <p>
         * j表示遍历指针：
         * nums[j]<nums[i] 时，dp[i]=Max(dp[j]+1,dp[i]) ，也就是i前面只要有一个j元素严格小于i，那么 i结尾的子序列就可以与j最长子序列组合
         * 原序列出现先递增后递减序列时，计算跨过波峰的子问题解时，就需要比较 Max(dp[j]+1,dp[i])
         */
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            // 初始默认每个元素结尾的最长递增子序列长度为1，也就是只包含 nums[i] 元素自身
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    // j前序元素出现了比i严格小的情况
                    if (nums[j] < nums[i]) {
                        // 根据状态转移方程，我们的子问题连接时，前序有小于当前基准值的情况下，子问题解可以在前一个子问题的解上+1，dp[i]取 dp[i]/dp[j]+1 的更大值
                        dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                    }
                }
            }

            // 题目所求为我们定义的子问题最优值
            int ans = dp[0];
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }


}
