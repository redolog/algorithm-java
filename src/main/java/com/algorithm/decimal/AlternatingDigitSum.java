package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/alternating-digit-sum/
 *
 * @author songhuilong001  @date 2023/8/4
 */
public class AlternatingDigitSum {

    public int alternateDigitSum(int n) {
        int sum = 0, sign = 1;
        String nStr = String.valueOf(n);
        for (int i = 0; i < nStr.length(); i++) {
            sum += sign * (nStr.charAt(i) - '0');
            sign = -sign;
        }
        return sum;
    }
}
