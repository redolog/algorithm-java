package com.algorithm.dataStructure.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 *
 * @author songhuilong  @date 2022/10/26
 */
public class TwoSumTarget {

    static class TwoPointerSolution {
        public int[] twoSum(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > target) {
                    // 需要更小的r
                    r--;
                } else if (sum < target) {
                    // 需要更大的l
                    l++;
                } else {
                    return new int[]{nums[l], nums[r]};
                }
            }
            return new int[]{};
        }
    }

    static class SetSolution {
        public int[] twoSum(int[] nums, int target) {
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            for (int num : nums) {
                if (set.contains(target - num)) {
                    return new int[]{num, target - num};
                }
            }
            return new int[]{};
        }
    }
}
