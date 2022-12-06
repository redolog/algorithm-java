package com.algorithm.decimal;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/number-of-different-integers-in-a-string/
 *
 * @author songhuilong  @date 2022/12/6
 */
public class NumberOfIntegersInAString {

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean strIsEmpty(StringBuilder str) {
        return null == str || str.length() == 0;
    }

    static class SetSolution {
        public int numDifferentIntegers(String word) {
            int n = word.length();
            Set<String> numSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                // 跳过非数字的部分
                while (i < n && !isDigit(word.charAt(i))) {
                    i++;
                }
                StringBuilder builder = new StringBuilder();
                while (i < n && isDigit(word.charAt(i))) {
                    builder.append(word.charAt(i));
                    i++;
                }
                // 去掉前导零
                while (builder.length() > 1 && builder.charAt(0) == '0') {
                    builder.deleteCharAt(0);
                }
                if (strIsEmpty(builder)) {
                    continue;
                }
                numSet.add(builder.toString());
            }
            return numSet.size();
        }
    }

}
