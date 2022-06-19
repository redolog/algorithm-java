package com.algorithm.dp;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * @author dragonsong  @date 2022/6/19
 */
public class FibonacciSequence {

    int[] cache;

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.1 MB
     * , 在所有 Java 提交中击败了
     * 58.15%
     * 的用户
     * 通过测试用例：
     * 51 / 51
     */
    public int fibWithTablation(int n) {
        if (n == 0) {
            return 0;
        }
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = (table[i - 1] + table[i - 2]) % 1000000007;
        }
        return table[n];
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        return recurse(n);
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.4 MB
     * , 在所有 Java 提交中击败了
     * 15.82%
     * 的用户
     * 通过测试用例：
     * 51 / 51
     */
    private int recurse(int n) {
        if (n == 0 || n == 1 || cache[n] != 0) {
            return cache[n];
        }
        cache[n] = (recurse(n - 1) + recurse(n - 2)) % 1000000007;
        return cache[n];
    }

}
