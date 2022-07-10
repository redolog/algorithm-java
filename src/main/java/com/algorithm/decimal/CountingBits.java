package com.algorithm.decimal;

/**
 * 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
 * <p>
 * https://leetcode.cn/problems/counting-bits/
 *
 * @author dragonsong  @date 2022/7/10
 */
public class CountingBits {

    static class CountByBit {
        /*
         * 执行用时：
         * 11 ms
         * , 在所有 Java 提交中击败了
         * 6.78%
         * 的用户
         * 内存消耗：
         * 45.8 MB
         * , 在所有 Java 提交中击败了
         * 5.71%
         * 的用户
         * 通过测试用例：
         * 15 / 15
         */

        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                ans[i] = countBit12(i);
            }
            return ans;
        }

        private int countBit1(int i) {
            int cnt = 0;
            while (i != 0) {
                int quotient = i / 2;
                int remainder = i % 2;
                if (remainder == 1) {
                    ++cnt;
                }
                i = quotient;
            }
            return cnt;
        }

        private int countBit12(int i) {
            int cnt = 0;
            // x & (x-1) 可消掉x末位1
            while (i != 0) {
                i &= (i - 1);
                cnt++;
            }
            return cnt;
        }
    }


}
