package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 * @author songhuilong001  @date 2022/11/21
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {

    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n > 0) {
            int remainder = n % 10;
            n = (n - remainder) / 10;
            product *= remainder;
            sum += remainder;
        }
        return product - sum;
    }
}
