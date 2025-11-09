package com.algorithm.dp;


/**
 * https://leetcode.cn/problems/house-robber/
 *
 * @author songhuilong  @date 2025/11/9
 */
public class HouseRobber {

    static class DPArraySolution {
        public int rob(int[] nums) {
            // 设 dp[i] 表示i的位置能偷到最大的金额
            // 以 n 为锚点，当前位置最大利益等同于当前位置偷或不偷的更大值，dp[n] = Max(nums[n]+dp[n-2], dp[n-1])
            int n = nums.length;
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = Math.max(
                        // nums[i] + (i>=2 ? dp[i-2] : 0),
                        nums[i] + getNum(dp, i - 2),
                        // (i>=1 ? dp[i-1] : 0)
                        getNum(dp, i - 1)
                );
            }
            return dp[n - 1];
        }

        private int getNum(int[] nums, int i) {
            if (i < 0 || i > nums.length - 1) {
                return 0;
            }
            return nums[i];
        }
    }

    static class ScrollArraySolution {
        // 上面解法的问题：当前能偷到最大值仅与 i-1/i-2 的两个前序值相关，因此可以仅维护两个值，不需要维护整个数组值
        // 使用滚动数组的方法优化上面解法

        public int rob(int[] nums) {
            // i1表示i-1即上一个值，i2表示i-2即上上个值
            int i1 = 0;
            int i2 = 0;
            int dp = 0;

            for (int i = 0; i < nums.length; i++) {
                // 题目所求 = 当前位置偷 | 不偷 所能获得的更大值
                dp = Math.max(nums[i] + i2, i1);
                i2 = i1;
                i1 = dp;
            }
            return dp;
        }
    }
}
