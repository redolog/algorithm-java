package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/
 *
 * @author songhuilong001  @date 2022/12/11
 */
public class MinimumOperationsToMakeTheArrayIncreasing {

    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }
}
