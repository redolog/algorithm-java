package com.algorithm.lookup;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-pivot-index/
 *
 * @author songhuilong  @date 2022/10/27
 */
public class FindPivotIndex {
    /**
     * 时间：O(n)
     * 空间：O(1)
     */
    public int pivotIndex(int[] nums) {
        // 初始时的右区间和
        int rSum = Arrays.stream(nums).sum(), lSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            rSum -= curr;
            if (rSum == lSum) {
                return i;
            }
            lSum += curr;
        }
        return -1;
    }
}
