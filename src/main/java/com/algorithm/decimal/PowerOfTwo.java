package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/power-of-two/
 *
 * @author songhuilong  @date 2022/9/14
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && ((1 << 30) % n) == 0;
    }

    public boolean isPowerOfTwo3(int n) {
        return n > 0 && (-n & n) == n;
    }
}
