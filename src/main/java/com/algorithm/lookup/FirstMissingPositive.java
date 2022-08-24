package com.algorithm.lookup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/first-missing-positive/
 *
 * @author dragonsong  @date 2022/8/24
 */
public class FirstMissingPositive {

    static class InplaceHash {
        /**
         * 原地hash，使用nums入参数组作为hashTable，nums[i]-1下标对应 nums[i]值
         * 过程：
         * - 将 nums[i]-1 有效下标范围的数据归位，即 x放在 x-1 的位置上，负数、0、大于n的数我们不动
         * - 依次从1开始遍历，没有归位的i值，即为缺失的最小正数
         * <p>
         * 时间复杂度 O(n)
         * 空间复杂度 O(1)
         */
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] - 1 >= 0 && nums[i] - 1 < n && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
            for (int i = 1; i <= n; i++) {
                if (nums[i - 1] != i) {
                    return i;
                }
            }
            return n + 1;
        }

        private void swap(int[] nums, int i1, int i2) {
            int tmp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = tmp;
        }
    }

    static class SetSolution {
        /**
         * 使用set计数、去重
         * 从1-n逐个遍历，找到不在set中的，即为第一个缺失的正数
         * <p>
         * 时间复杂度 O(n)
         * 空间复杂度 O(n)
         */
        public int firstMissingPositive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (num > 0) {
                    set.add(num);
                }
            }
            for (int i = 1; i <= nums.length; i++) {
                if (!set.contains(i)) {
                    return i;
                }
            }
            return nums.length + 1;
        }
    }

    static class Sort {
        public int firstMissingPositive(int[] nums) {
            // 整体空间复杂度 O(1)
            // n*logn
            Arrays.sort(nums);
            // 使用二分查找的话，查找部分复杂度又是 n*logn
            // 使用遍历查找的话，查找部分只需要 n 的复杂度
            int pre = 0;
            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];
                if (curr < 0 || curr == pre) {
                    // 负数、重复值，跳过
                    continue;
                }

                if (curr != pre + 1) {
                    return pre + 1;
                }

                pre = curr;
            }
            return pre + 1;
        }
    }

}
