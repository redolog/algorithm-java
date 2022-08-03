package com.algorithm.decimal;

/**
 * 868. 二进制间距
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 * <p>
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 22
 * 输出：2
 * 解释：22 的二进制是 "10110" 。
 * 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 * 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 * 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 * 示例 2：
 * <p>
 * 输入：n = 8
 * 输出：0
 * 解释：8 的二进制是 "1000" 。
 * 在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
 * 示例 3：
 * <p>
 * 输入：n = 5
 * 输出：2
 * 解释：5 的二进制是 "101" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * <p>
 * https://leetcode.cn/problems/binary-gap/
 *
 * @author dragonsong  @date 2022/8/3
 */
public class BinaryGap {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.2 MB
     * , 在所有 Java 提交中击败了
     * 81.83%
     * 的用户
     * 通过测试用例：
     * 261 / 261
     */

    public int binaryGap(int n) {
        int ans = 0, prev = Integer.MAX_VALUE;
        for (int i = 0; n > 0; i++) {
            if ((n & 1) == 1) {
                ans = Math.max(ans, i - prev);
                prev = i;
            }
            n >>= 1;
        }
        return ans;
    }

    public int binaryGap2(int n) {
        int ans = 0, prev = Integer.MAX_VALUE;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ans = Math.max(ans, i - prev);
                prev = i;
            }
        }
        return ans;
    }
}
