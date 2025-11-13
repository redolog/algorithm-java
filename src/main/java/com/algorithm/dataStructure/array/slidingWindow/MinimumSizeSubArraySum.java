package com.algorithm.dataStructure.array.slidingWindow;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 *
 * @author songhuilong  @date 2025/11/13
 */
public class MinimumSizeSubArraySum {

    // 算法概述：使用滑动窗口逐个窗口进行判断，题目给定所有元素均为正数，意味着左边界右移后，右指针一定是右移或者不动的。
    // 1. 初始化 [l,r] 两个边界指针；
    // 2. l指针每一轮挪动一个位置，右指针判断当前窗口和是否大于等于target，如果小于则右指针一直右移，直到满足和大于等于target；
    // 3. 维护一个窗口长度，每一轮更新其最小值；
    // 4. 当左指针移到最右，结束整个过程；
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        // 当前窗口和
        int windowSum = 0;
        // 窗口最小长度
        int windowMinSize = Integer.MAX_VALUE;

        for (; l < n; l++) {
            if (l > 0) {
                // 扣减掉上一轮左边界的值
                windowSum -= nums[l - 1];
            }

            while (r < n && windowSum < target) {
                windowSum += nums[r++];
            }

            if (windowSum < target) {
                break;
            }

            windowMinSize = Math.min(windowMinSize, r - l);
        }
        return windowMinSize == Integer.MAX_VALUE ? 0 : windowMinSize;
    }
}
