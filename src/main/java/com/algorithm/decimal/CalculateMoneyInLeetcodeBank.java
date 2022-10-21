package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/calculate-money-in-leetcode-bank/
 *
 * @author songhuilong  @date 2022/10/21
 */
public class CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        int base = 1, ans = 0;
        for (int i = 0; i < n / 7 + 1; i++) {
            if (i == n / 7) {
                // 最后一周
                for (int j = 0; j < n % 7; j++) {
                    ans += base + j;
                }
            } else {
                ans += 28 + (base - 1) * 7;
            }
            base++;
        }
        return ans;
    }
}
