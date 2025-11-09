package com.algorithm.dataStructure.array.preSum;


/**
 * https://leetcode.cn/problems/product-of-array-except-self
 *
 * @author songhuilong  @date 2025/11/9
 */
public class ProductOfArrayExceptSelf {

    static class PrefixSuffixArraySolution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            // 算法概述：维护两个前缀、后缀乘积数组
            // prefix[i] 表示i左侧数乘积
            // suffix[i] 表示i右侧数乘积
            // 所求 product[i] = prefix[i] * suffix[i]
            // 维护前缀后缀乘积时，仅需一次遍历原输入数组
            int[] prefix = new int[n];
            prefix[0] = 1;
            int[] suffix = new int[n];
            suffix[n - 1] = 1;
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] * nums[i - 1];
                int r = n - i - 1;
                suffix[r] = suffix[r + 1] * nums[r + 1];
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = prefix[i] * suffix[i];
            }
            return ans;
        }
    }

    static class AnswerArraySolution {
        public int[] productExceptSelf(int[] nums) {
            // 上述解法使用了两个额外的辅助数组，空间复杂度O(n)
            // 实际上我们可以借助答案数组来替代两个前缀、后缀数组，计算逻辑是一致的
            // 答案数组首先从左往右遍历，维护前缀乘积
            // 然后从右往左遍历，维护后缀乘积
            // 每次遍历过程中，除nums[i]外的乘积已构建完成
            int n = nums.length;
            int[] ans = new int[n];
            ans[0] = 1;
            int product = 1;
            // 从左往右遍历，ans构建前缀乘积
            for (int i = 1; i < n; i++) {
                product *= nums[i - 1];
                ans[i] = product;
            }
            product = 1;
            // 从右往左遍历，ans每个元素乘以
            for (int i = 1; i < n; i++) {
                int r = n - 1 - i;
                product *= nums[r + 1];
                ans[r] *= product;
            }
            return ans;
        }
    }

}
