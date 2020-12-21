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
        int[] cache = new int[n];
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

}
