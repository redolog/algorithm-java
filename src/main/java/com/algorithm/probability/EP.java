package com.algorithm.probability;

/**
 * 等概率实现
 *
 * EqualProbability
 *
 * @author dragonsong  @date 2022/5/25
 */
public class EP {

    public static int rand15() {
        // 等概率返回1-5，我们使用 random() 实现
        return (int) (Math.random() * 5 + 1);
    }

    /**
     * equal probability (EP
     * <p>
     * 思路：首先基于 rand15() ，我们实现一个 0，1 等概率函数
     *
     * @return rand15()返回1时重试，返回2，3我们返回0，返回4，5我们返回1，
     */
    public static int epBaseRand15() {
        int ans;
        do {
            ans = rand15();
        } while (ans == 1);
        return ans < 4 ? 0 : 1;
    }

    /**
     * 基于random() 生成随机数，
     *
     * @param seed 一个当次调用传入的随机种子
     * @return 小于 seed 时，返回0，否则返回1
     */
    public static int rand01(double seed) {
        return Math.random() < seed ? 0 : 1;
    }

    /**
     * 基于 rand01 ，实现等概率函数
     */
    public static int epBaseRand01() {
        double seed = Math.random();
        int ans;
        // epBaseRand01 内调用至少两次 rand01 ，保证两次调用返回0+1，此时概率为1，第二次调用与第一次相同时，重试
        // p为概率, 01 10 00 11 概率分别为 1/4 ((1/2)^2)
        do {
            ans = rand01(seed);
        } while (ans == rand01(seed));
        return ans == 0 ? 0 : 1;
    }

    public static int rand03() {
        return (epBaseRand01() << 1) + epBaseRand01();
    }

    public static int rand13() {
        int ans;
        do {
            ans = rand03();
            // 保证每轮都输出 1、2、3
        } while (ans == 0);
        return ans;
    }
}
