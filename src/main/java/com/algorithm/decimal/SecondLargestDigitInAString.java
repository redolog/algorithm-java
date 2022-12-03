package com.algorithm.decimal;

import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * https://leetcode.cn/problems/second-largest-digit-in-a-string/
 *
 * @author songhuilong001  @date 2022/12/3
 */
public class SecondLargestDigitInAString {

    static class LoopOnce {
        public int secondHighest(String s) {
            int secondMax = -1, max = -1;
            for (int i = 0; i < s.length(); i++) {
                int curr = s.charAt(i) - '0';
                if (curr < 0 || curr > 9) {
                    continue;
                }

                if (curr > max) {
                    secondMax = max;
                    max = curr;
                } else if (curr < max && curr > secondMax) {
                    secondMax = curr;
                }
            }
            return secondMax;
        }
    }

    static class LoopTwice {
        public int secondHighest(String s) {
            int secondMax = -1, max = -1;
            max = loop(s, max, Math::max, curr -> curr < 0 || curr > 9);
            int finalMax = max;
            secondMax = loop(s, secondMax, Math::max, curr -> curr < 0 || curr > 9 || curr == finalMax);
            return secondMax;
        }

        /**
         * @param s             入参字符串
         * @param ans           答案值
         * @param function      输入答案值（max/secondMax）、当前循环中元素所做的处理
         * @param skipPredicate 循环中跳过的条件
         * @return 跳过 skipPredicate 后，满足 function 的 ans
         */
        private int loop(String s, int ans, BiFunction<Integer, Integer, Integer> function, Predicate<Integer> skipPredicate) {
            for (int i = 0; i < s.length(); i++) {
                int curr = s.charAt(i) - '0';
                if (skipPredicate.test(curr)) {
                    continue;
                }
                ans = function.apply(ans, curr);
            }
            return ans;
        }
    }
}
