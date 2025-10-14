package com.algorithm.dataStructure.array.subArr;


import java.util.List;

/**
 * https://leetcode.cn/problems/adjacent-increasing-subarrays-detection-i
 *
 * @author songhuilong  @date 2025/10/14
 */
public class AdjacentIncreasingSubarrayDetect {
    public static class IterationSolution {
        public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
            if (k == 1) {
                return true;
            }
            // 思路：逐个遍历nums数组，从a下标开始依次判定右向的两个连续k子数组是否满足相邻递增
            // 如不满足则从a+1继续判断

            int n = nums.size();
            for (int a = 0; a + 2 * k - 1 < n; a++) {
                int b = a + k;
                if (isIncreasingArr(a, k, nums) && isIncreasingArr(b, k, nums)) {
                    return true;
                }
            }
            return false;
        }

        // a：区间左下标
        // k：区间长度
        public boolean isIncreasingArr(int a, int k, List<Integer> nums) {
            for (int i = a + 1; i < a + k; i++) {
                if (nums.get(i - 1) >= nums.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

}
