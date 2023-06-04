package com.algorithm.dataStructure.array.app.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/number-of-distinct-averages/
 *
 * @author songhuilong001  @date 2023/6/4
 */
public class NumberOfDistinctAverages {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = n - 1;
        Set<Double> avgSet = new HashSet<>();
        while (l < r) {
            avgSet.add(((double) nums[l++] + (double) nums[r--]) / 2);
        }
        return avgSet.size();
    }
}
