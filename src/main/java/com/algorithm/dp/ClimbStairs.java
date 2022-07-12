package com.algorithm.dp;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author DragonSong  @date 2020/12/21
 * @link {https://leetcode-cn.com/problems/climbing-stairs/}
 */
public class ClimbStairs {

    /**
     * 1:1
     * 2:2
     * 3:3
     * 4:5
     * 5:8
     *
     * @return 求符合条件的组合数
     */
    public static int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return cache(n, cache);
    }

    private static int rude(int n) {
        if (n < 2) {
            return n;
        }
        return rude(n - 1) + rude(n - 2);
    }

    private static int cache(int n, int[] cache) {
        if (n < 2) {
            return n;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        cache[n] = cache(n - 1, cache) + cache(n - 2, cache);
        return cache[n];
    }

    public int table(int n) {
        if (n == 0) {
            return 0;
        }
        int[] table = new int[n + 1];

        //base cases
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    static class DP {
        /**
         * 爬n个楼梯的方案：爬n-1个楼梯的方案+爬n-2个楼梯的方案
         * f(n)=f(n-1)+f(n-2)
         */
        public int climbStairs(int n) {
            // 一阶跟零阶，都只有一种方案
            if (n == 1 || n == 0) {
                return 1;
            }
            int a = 1, b = 1;
            for (int i = 2; i < n; i++) {
                int aTmp = a;
                a = b;
                b = aTmp + b;
            }
            return a + b;
        }
    }
}
