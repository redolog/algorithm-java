package com.algorithm.dataStructure.array.slidingWindow;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * @author songhuilong  @date 2025/11/16
 */
public class MinimumOperationsReduceToX {

    public int minOperations(int[] nums, int x) {
        // 算法概述：问题转化为寻找 和为 sum(nums)-x 的最长子数组（最长保证减到0操作数最小）
        // 过程：使用双指针维护窗口，左窗口依次从0下标出发，右窗口挪动到和 >= sum(nums)-x 处，重复此过程，计算窗口最大长度
        // 边界：
        // 1. sum(nums)-x < 0 ，不存在答案，直接返回-1；
        // 2. 窗口和 > sum(nums)-x，不计入有效；
        int n = nums.length;
        int arrSum = 0;
        for (int num : nums) {
            arrSum += num;
        }
        int ans = -1;
        if (arrSum < x) {
            return ans;
        }
        if (arrSum == x) {
            return n;
        }

        int sum = 0;
        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r < n && sum < arrSum - x) {
                sum += nums[r++];
            }
            if (sum == arrSum - x) {
                ans = Math.max(ans, r - l);
            }
            sum -= nums[l];
        }
        return ans == -1 ? ans : n - ans;
    }

    static class PreSumSolution {
        public int minOperations(int[] nums, int x) {
            // 解法2：维护前缀和，数组总和为sum，给定x，通过两段前缀和差值来检索和为 sum-x 的子数组段
            // 由于题目求最小操作数，对应我们要寻找和为sum-x的最长子数组，因此前缀和映射同时维护出现的最早下标
            int n = nums.length;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int ans = -1;
            if (sum < x) {
                return ans;
            }
            if (sum == x) {
                return n;
            }
            Map<Integer, Integer> prefixSum2EarliestIdx = new HashMap<>();
            prefixSum2EarliestIdx.put(0, -1);
            int prefixSum = 0;
            for (int i = 0; i < n; i++) {
                prefixSum += nums[i];
                prefixSum2EarliestIdx.putIfAbsent(prefixSum, i);

                Integer earliestIdx = prefixSum2EarliestIdx.get(prefixSum - sum + x);

                if (earliestIdx != null) {
                    ans = Math.max(ans, i - earliestIdx);
                }
            }
            return ans == -1 ? ans : n - ans;

        }
    }
}
