package com.algorithm.decimal;

import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/
 *
 * @author songhuilong001  @date 2022/11/29
 */
public class MinimumChangesToMakeAlternatingBinaryString {

    public int minOperations(String s) {
        // 对 010101 的转换操作计数
        int cnt = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (i % 2 != s.charAt(i) - '0') {
                cnt++;
            }
            // 观察可得：i的奇偶性与当前字符值相等或者相反时，可表示本题的0101  或者 1010
//            if ((i % 2 == 0 && s.charAt(i) == '1') || (i % 2 == 1 && s.charAt(i) == '0')) {
//                cnt++;
//            }
        }
        return Math.min(cnt, n - cnt);
    }

    static class StreamSolution {
        public int minOperations(String s) {
            int n = s.length(), cnt = (int) IntStream.range(0, n)
                    .filter(i -> i % 2 != s.charAt(i) - '0')
                    .count();
            return Math.min(cnt, n - cnt);
        }
    }
}
