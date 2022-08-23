package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/ugly-number/
 *
 * @author dragonsong  @date 2022/8/23
 */
public class UglyNumber {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    public boolean isUgly2(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
