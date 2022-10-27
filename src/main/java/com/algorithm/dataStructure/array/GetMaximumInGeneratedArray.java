package com.algorithm.dataStructure.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/get-maximum-in-generated-array/
 *
 * @author songhuilong  @date 2022/10/27
 */
public class GetMaximumInGeneratedArray {

    /**
     * 时间：O(n+1)
     * 空间：O(n+1)
     */
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 0; i < n + 1; i++) {
            if (2 * i < n + 1) {
                nums[2 * i] = nums[i];
            }
            if (2 * i + 1 < n + 1) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
