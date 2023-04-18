package com.algorithm.decimal;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-the-maximum-divisibility-score/">2644. Find the Maximum Divisibility Score</a>
 *
 * @author songhuilong  @date 2023/4/18
 */
public class FindTheMaximumDivisibilityScore {

    static class IterationSolution {
        public int maxDivScore(int[] nums, int[] divisors) {
            int maxScore = 0, ans = Integer.MAX_VALUE;
            for (int i = divisors.length - 1; i >= 0; i--) {
                int score = 0;
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (nums[j] % divisors[i] == 0) {
                        score++;
                    }
                }
                // 当前被整除分更高 或者 分一样但是数更小
                if (score > maxScore || (score == maxScore && divisors[i] < ans)) {
                    ans = divisors[i];
                    maxScore = score;
                }
            }
            return ans;
        }
    }

    static class SortSolution {
        public int maxDivScore(int[] nums, int[] divisors) {
            Arrays.sort(divisors);

            int maxScore = 0, ans = 0;
            for (int i = divisors.length - 1; i >= 0; i--) {
                int score = 0;
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (nums[j] % divisors[i] == 0) {
                        score++;
                    }
                }
                if (score >= maxScore) {
                    ans = divisors[i];
                    maxScore = score;
                }
            }
            return ans;
        }
    }

}
