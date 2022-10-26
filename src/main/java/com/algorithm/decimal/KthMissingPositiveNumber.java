package com.algorithm.decimal;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/kth-missing-positive-number/
 *
 * @author songhuilong  @date 2022/10/26
 */
public class KthMissingPositiveNumber {

    static class TwoPointerSolution {
        /**
         * 时间复杂度：O(k)
         * 空间复杂度：O(1)
         */
        public int findKthPositive(int[] arr, int k) {
            // i遍历arr，利用arr严格递增的特性
            // curr 表示严格递增、连续的正整数
            int i = 0, curr = 1, n = arr.length;
            while (true) {
                if (i >= n || arr[i] != curr) {
                    // 记录一个curr缺失
                    k--;
                } else {
                    i++;
                }
                if (k == 0) {
                    return curr;
                }
                curr++;
            }
        }
    }

    static class SetSolution {
        /**
         * 时间复杂度：O(k)
         * 空间复杂度：O(n)
         */
        public int findKthPositive(int[] arr, int k) {
            Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
            int curr = 1;
            while (true) {
                if (!set.contains(curr)) {
                    k--;
                }
                if (k == 0) {
                    return curr;
                }
                curr++;
            }
        }
    }
}
