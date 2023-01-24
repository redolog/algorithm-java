package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/calculate-amount-paid-in-taxes/
 *
 * @author songhuilong001  @date 2023/1/23
 */
public class CalculateAmountPaidInTaxes {

    public double calculateTax(int[][] brackets, int income) {
        // 记录前一档upper右区间
        int pre = 0;
        double ans = 0D;
        for (int[] bracket : brackets) {
            int upper = bracket[0];
            int percent = bracket[1];
            int range = Math.min(income - pre, upper - pre);
            ans += (double) range * ((double) percent / 100);
            pre = upper;
            if (income < upper) {
                break;
            }
        }
        return ans;
    }
}
