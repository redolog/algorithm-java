package com.algorithm.dataStructure.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/array-partition/
 *
 * @author DragonSong  @date 2022/11/9
 */
public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                ans += nums[i];
            }
        }
        return ans;
    }
}
