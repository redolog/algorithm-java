package com.algorithm.decimal;

import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/number-of-common-factors/
 *
 * @author DragonSong  @date 2022/10/30
 */
public class NumberOfCommonFactors {

    static class LoopSolution {
        public int commonFactors(int a, int b) {
            int ans = 0, maxFactor = Math.min(a, b);
            for (int i = 1; i <= maxFactor; i++) {
                if (a % i == 0 && b % i == 0) {
                    ans++;
                }
            }
            return ans;
        }
    }

    static class StreamSolution {
        public int commonFactors(int a, int b) {
            return (int) IntStream.rangeClosed(1, Math.min(a, b))
                    .filter(i -> a % i == 0 && b % i == 0)
                    .count();
        }
    }
}
