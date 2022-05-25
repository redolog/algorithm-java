package com.algorithm.probability;

/**
 * 已知一个等概率随机函数 rand15()，随机返回 1-5
 * 求新的rand17() 函数，等概率返回1-7
 */
public class Rand2Rand {



    /**
     * // ep等概率返回0、1，我们使用一个三位二进制数来枚举概率结果，一共 2^2+2^1+1 其中情况
     * // 此时我们表达了 0-8数字情况，将0的情况去掉，则正好是 1-7 范围等概率随机结果
     */
    public static int rand07() {
        return (EqualProbability.epBaseRand15() << 2) + (EqualProbability.epBaseRand15() << 1) + (EqualProbability.epBaseRand15());
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
