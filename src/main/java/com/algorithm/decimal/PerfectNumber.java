package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/perfect-number/
 *
 * @author songhuilong  @date 2022/9/30
 */
public class PerfectNumber {

    /**
     * 逐个因子计算，时间复杂度：O(sqrt(n))
     * 空间复杂度：O(1)
     */
    public boolean checkPerfectNumber(int num) {
        // 因子factor从1开始，sum求和，r表示右边界，最开始r==num/2
        int factor = 1, sum = 0, r = num / 2;
        while (factor < r) {
            if (num % factor == 0) {
                if (factor != num) {
                    sum += factor;
                }
                if (num / factor != num) {
                    sum += num / factor;
                    r = num / factor;
                }
            }
            factor++;
        }
        return sum == num;
    }
}
