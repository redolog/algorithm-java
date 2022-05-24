package com.algorithm.probability;

/**
 * 已知一个等概率随机函数 rand15()，随机返回 1-5
 * 求新的rand17() 函数，等概率返回1-7
 */
public class Rand2Rand {

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
    public static int ep() {
        int ans;
        do {
            ans = rand15();
        } while (ans == 1);
        return ans < 4 ? 0 : 1;
    }

    /**
     * // ep等概率返回0、1，我们使用一个三位二进制数来枚举概率结果，一共 2^2+2^1+1 其中情况
     * // 此时我们表达了 0-8数字情况，将0的情况去掉，则正好是 1-7 范围等概率随机结果
     */
    public static int rand07() {
        return (ep() << 2) + (ep() << 1) + (ep());
    }

    /**
     * 基于 ep rand07 实现 1-7 范围判断
     */
    public static int rand17() {
        int ans;
        do {
            ans = rand07();
        } while (ans == 0);
        return ans;
    }

}
