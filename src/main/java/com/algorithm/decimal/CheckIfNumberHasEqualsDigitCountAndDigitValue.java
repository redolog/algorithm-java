package com.algorithm.decimal;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/
 *
 * @author songhuilong  @date 2023/1/11
 */
public class CheckIfNumberHasEqualsDigitCountAndDigitValue {

    public boolean digitCount(String num) {
        Map<Integer, Integer> digit2Cnt = new HashMap<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            int digit = (int) num.charAt(i) - '0';
            digit2Cnt.put(digit, digit2Cnt.getOrDefault(digit, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int digit = (int) num.charAt(i) - '0';
            if (!digit2Cnt.getOrDefault(i, 0).equals(digit)) {
                return false;
            }
        }
        return true;
    }
}
