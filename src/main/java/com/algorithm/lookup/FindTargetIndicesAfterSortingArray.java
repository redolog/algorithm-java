package com.algorithm.lookup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-target-indices-after-sorting-array/
 *
 * @author songhuilong001  @date 2022/12/5
 */
public class FindTargetIndicesAfterSortingArray {

    static class Sort {
        public List<Integer> targetIndices(int[] nums, int target) {
            List<Integer> ans = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

    static class Cnt {
        public List<Integer> targetIndices(int[] nums, int target) {
            List<Integer> ans = new ArrayList<>();
            int smallerCnt = 0, biggerCnt = 0, n = nums.length;
            for (int num : nums) {
                if (num < target) {
                    smallerCnt++;
                }
                if (num > target) {
                    biggerCnt++;
                }
            }
            for (int i = smallerCnt; i < n - biggerCnt; i++) {
                ans.add(i);
            }
            return ans;
        }
    }

}
