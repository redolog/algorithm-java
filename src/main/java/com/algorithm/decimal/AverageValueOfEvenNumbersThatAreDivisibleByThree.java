package com.algorithm.decimal;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/">2455. Average Value of Even Numbers That Are Divisible by Three</a>
 *
 * @author songhuilong  @date 2023/5/29
 */
public class AverageValueOfEvenNumbersThatAreDivisibleByThree {

    static class LoopSolution {
        public int averageValue(int[] nums) {
            int cnt = 0, sum = 0;
            for (int num : nums) {
                if (num % 6 == 0) {
                    cnt++;
                    sum += num;
                }
            }
            return cnt == 0 ? 0 : sum / cnt;
        }
    }

}
