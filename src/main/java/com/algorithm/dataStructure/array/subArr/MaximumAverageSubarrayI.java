package com.algorithm.dataStructure.array.subArr;

/**
 * https://leetcode.cn/problems/maximum-average-subarray-i/
 *
 * @author songhuilong  @date 2022/10/27
 */
public class MaximumAverageSubarrayI {

    /**
     * 时间：O(n)
     * 空间：O(1)
     */
    public double findMaxAverage(int[] nums, int k) {
        double sumK = 0, avg;
        // 首先计算第一批k个数的和、平均数
        for (int i = 0; i < k; i++) {
            sumK += nums[i];
        }
        avg = sumK / k;
        for (int i = k; i < nums.length; i++) {
            // 减去上一批第一个数
            sumK -= nums[i - k];
            // 增加本批最后一个数
            sumK += nums[i];
            avg = Math.max(sumK / k, avg);
        }
        return avg;
    }
}
