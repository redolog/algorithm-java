package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/find-greatest-common-divisor-of-array/
 *
 * @author songhuilong  @date 2022/9/9
 */
public class FindGreatestCommonDivisorOfArray {

    /**
     * 时间复杂度：O(n+logn)
     * 空间复杂度：O(1)
     */
    public int findGCD(int[] nums) {
        int min = 1001, max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return gcd(min, max);
    }

    public int gcd(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend;
        }
        // 计算公式gcd(a,b) = gcd(b,a mod b)。
        return gcd(divisor, dividend % divisor);
    }
}
