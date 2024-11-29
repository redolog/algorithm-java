package com.algorithm.greedy;

import java.util.Arrays;

/**
 * 55. 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * https://leetcode.cn/problems/jump-game/description/
 *
 * @author songhuilong  @date 2024/11/29
 */
public class JumpGame {

    public static class GreedySolution {
        public boolean canJump(int[] nums) {
            // 模拟跳跃过程，遍历入参，维护能到达的最大下标，只要当前下标小于等于最大下标，当前就能跳到，否则，中断跳跃
            int maxIdx = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (maxIdx < i) {
                    return false;
                }
                maxIdx = Math.max(maxIdx, i + nums[i]);
            }
            return true;
        }
    }

    public static class DPSolution {
        public boolean canJump(int[] nums) {
            // dp[i] 表示当前位置能否跳到，而dp[i]= dp[<i]+nums[<i] >= i ? true : false
            int n = nums.length;
            boolean[] dp = new boolean[n];
            Arrays.fill(dp, false);
            // 默认第一个位置一定能跳到
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                if (!dp[i]) {
                    return false;
                }
                // 从当前位置，标记 nums[i] 段为true
                for (int j = i + 1; j < n && j <= i + nums[i]; j++) {
                    dp[j] = true;
                }
            }
            return dp[n - 1];
        }
    }
}
