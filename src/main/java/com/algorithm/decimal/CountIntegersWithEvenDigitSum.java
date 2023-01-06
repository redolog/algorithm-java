package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/count-integers-with-even-digit-sum/
 *
 * @author songhuilong  @date 2023/1/6
 */
public class CountIntegersWithEvenDigitSum {

    public int countEven(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            int curr = i, sum = 0;
            while (curr > 0) {
                sum += curr % 10;
                curr /= 10;
            }
            if ((sum & 1) == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
