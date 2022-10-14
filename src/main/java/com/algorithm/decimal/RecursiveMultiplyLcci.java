package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/recursive-mulitply-lcci/
 *
 * @author songhuilong  @date 2022/10/14
 */
public class RecursiveMultiplyLcci {

    static class Recursion {
        /**
         * 递推公式：max * min = max + (min-1)*max
         * 边界：min==1时，此时 max*min==max
         * <p>
         * 由于此时min为较小值，因此递归次数更少，尽可能减少递归栈深度
         */
        public int multiply(int A, int B) {
            int min = Math.min(A, B), max = Math.max(A, B);
            if (min == 1) {
                return max;
            }
            return max + multiply(min - 1, max);
        }
    }

    static class Traversal {
        /**
         * 使用加法实现乘法，同时我们尽可能减少加的次数，因此先求出较小值
         */
        public int multiply(int A, int B) {
            int min = Math.min(A, B), max = Math.max(A, B);
            int ans = 0;
            for (int i = 0; i < min; i++) {
                ans += max;
            }
            return ans;
        }
    }

}
