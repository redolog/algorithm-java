package com.algorithm.dataStructure.array.slidingWindow;

/**
 * 给你一个长度为 n 的整数数组 nums 和一个正整数 k 。
 * <p>
 * 一个数组的 能量值 定义为：
 * <p>
 * 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。
 * 否则为 -1 。
 * 你需要求出 nums 中所有长度为 k 的子数组的能量值。
 * <p>
 * 请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能量值。
 *
 * <a href="https://leetcode.cn/problems/find-the-power-of-k-size-subarrays-i">3254. 长度为 K 的子数组的能量值 I</a>
 *
 * @author songhuilong  @date 2024/11/8
 */
public class FindThePowerOfKSizeSubArraysI {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // 预填充默认能量值-1
        for (int i = 0; i < n - k + 1; i++) {
            ans[i] = -1;
        }
        int segmentCnt = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || k == 1 || nums[i] - nums[i - 1] == 1) {
                // 数组第一个数 || 段长度为1 || 连续上升
                segmentCnt++;
            } else {
                // 不连续上升，开始新的段计数
                segmentCnt = 1;
            }
            if (segmentCnt == k) {
                ans[i - k + 1] = nums[i];
                // 当前末尾能量值已记录，队头出队
                segmentCnt--;
            }
        }
        return ans;
    }

}
