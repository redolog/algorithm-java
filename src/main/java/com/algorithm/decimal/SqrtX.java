package com.algorithm.decimal;

/**
 * 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= x <= 231 - 1
 * <p>
 * https://leetcode.cn/problems/sqrtx/
 *
 * @author dragonsong  @date 2022/7/12
 */
public class SqrtX {

    /*
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 94.70%
     * 的用户
     * 内存消耗：
     * 39 MB
     * , 在所有 Java 提交中击败了
     * 12.85%
     * 的用户
     * 通过测试用例：
     * 1017 / 1017
     */

    public int mySqrt(int x) {
        // 精度 精确到整数级别
        int precision = 1;

        int low = 0;
        int high = x;

        while (low < high) {
            if (low == high - precision) {
                if (high <= x / high) {
                    low = high;
                }
                break;
            }

            int mid = low + ((high - low) >> 1);

            if (mid > x / mid) {
                high = mid - 1;
            } else if (mid <= x / mid) {
                low = mid;
            }
        }
        return low;

    }
}
