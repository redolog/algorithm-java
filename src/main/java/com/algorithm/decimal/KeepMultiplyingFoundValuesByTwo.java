package com.algorithm.decimal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/keep-multiplying-found-values-by-two/
 *
 * @author songhuilong  @date 2023/2/28
 */
public class KeepMultiplyingFoundValuesByTwo {

    static class SetSolution {
        /**
         * 时间：O(n)
         * 空间：O(n)
         */
        public int findFinalValue(int[] nums, int original) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            while (set.contains(original)) {
                original = original * 2;
            }
            return original;
        }
    }

    static class BF {
        /**
         * 时间：O(n^2)
         * 空间：O(1)
         */
        public int findFinalValue(int[] nums, int original) {
            while (find(nums, original)) {
                original = original * 2;
            }
            return original;
        }

        private boolean find(int[] nums, int original) {
            for (int num : nums) {
                if (num == original) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Sort {
        /**
         * 时间：O(n*logn)
         * 空间：O(logn)
         */
        public int findFinalValue(int[] nums, int original) {
            Arrays.sort(nums);
            for (int num : nums) {
                if (num == original) {
                    original = original * 2;
                }
            }
            return original;
        }
    }
}
