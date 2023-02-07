package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 *
 * @author songhuilong  @date 2023/2/7
 */
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (valid(i) && valid(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return null;
    }

    private boolean valid(int i) {
        while (i > 0) {
            if (i % 10 == 0) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}
