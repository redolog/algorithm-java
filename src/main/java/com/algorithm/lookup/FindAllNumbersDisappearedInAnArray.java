package com.algorithm.lookup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author dragonsong  @date 2022/8/24
 */
public class FindAllNumbersDisappearedInAnArray {

    static class BF {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(i + 1)) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }

    static class InPlaceHash {
        /**
         * 原地hash，使用入参数组，进行数据还原。
         * 题干限定了数据范围为 [1,n]，尝试将当前下标的数替换到对应下标上，nums[i]下标对应：nums[i]-1
         * 碰到下标 nums[i]-1 处 与当前值相同时，进行下一个下标处理
         * <p>
         * 最终，遍历整个数组，下标处值不等于 i+1 的，即为缺失的数据
         * <p>
         * 时间复杂度 O(n)
         * 空间复杂度 O(1)
         */

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                // 当前位置值与下标不匹配，同时 nums[i]-1 下标处于当前值不等
                while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }

        private void swap(int[] nums, int i1, int i2) {
            int tmp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = tmp;
        }
    }

}
