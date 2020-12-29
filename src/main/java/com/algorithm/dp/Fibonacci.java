package com.algorithm.dp;

/**
 * 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 ≤ N ≤ 30
 *
 * @author DragonSong  @date 2020/12/29
 * @link {https://leetcode-cn.com/problems/fibonacci-number/}
 */

public class Fibonacci {
    public int fib(int n) {
        return tabulation(n);
    }

    private int tabulation(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        if (n == 0) {
            return nums[n];
        }

        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    private int recursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    private int recurseWithCache(int n) {
        if (n <= 1) {
            return n;
        }
        int[] cache = new int[n + 1];
        return recurseWithCache(n - 1, cache) + recurseWithCache(n - 2, cache);
    }

    private int recurseWithCache(int n, int[] cache) {
        if (cache[n] != 0) {
            return cache[n];
        }
        int targetVal = recurseWithCache(n - 1, cache) + recurseWithCache(n - 2, cache);
        cache[n] = targetVal;
        return targetVal;
    }
}
