package com.algorithm.dataStructure.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 *
 * @author DragonSong  @date 2022/9/12
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[0] >= n) {
            // 第一个数就比n大，说明n就是x
            return n;
        }
        for (int x = 1; x < n; x++) {
            if (nums[n - x] >= x && nums[n - x - 1] < x) {
                return x;
            }
        }
        return -1;
    }

}
