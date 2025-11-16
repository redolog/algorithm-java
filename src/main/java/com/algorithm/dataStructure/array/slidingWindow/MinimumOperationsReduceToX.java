package com.algorithm.dataStructure.array.slidingWindow;


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
}
