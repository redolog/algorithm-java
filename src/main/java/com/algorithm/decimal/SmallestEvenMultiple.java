package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/smallest-even-multiple/
 *
 * @author songhuilong  @date 2022/10/10
 */
public class SmallestEvenMultiple {

    /**
     * 偶数直接返回偶数，奇数返回 n*2
     */
    public int smallestEvenMultiple(int n) {
        if ((n & 1) == 0) {
            return n;
        }
        return n * 2;
    }

    /**
     * 奇数对2取模返回1，偶数对2取模返回0
     */
    public int smallestEvenMultiple2(int n) {
        return (n % 2 + 1) * n;
    }
}
