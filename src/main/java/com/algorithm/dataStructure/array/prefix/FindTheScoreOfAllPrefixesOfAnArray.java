package com.algorithm.dataStructure.array.prefix;

/**
 * https://leetcode.cn/problems/find-the-score-of-all-prefixes-of-an-array/
 *
 * @author songhuilong001  @date 2023/4/16
 */
public class FindTheScoreOfAllPrefixesOfAnArray {

    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        // 将nums中每一项转换为 conver转换值
        long[] conver = new long[n];
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            conver[i] = nums[i] + max;
        }

        long converSum = 0L;
        for (int i = 0; i < n; i++) {
            converSum += conver[i];
            ans[i] = converSum;
        }
        return ans;
    }
}
