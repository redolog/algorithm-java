package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/roman-to-integer/
 *
 * @author songhuilong  @date 2025/11/13
 */
public class RomanToInteger {

    // 算法概述：依次判断当前字符，检查下一个字符是否可与当前字符成对，不能成对则单独计数
    // 1. 可成对：下一字符数值比当前大，则当前对数值 = 下一字符数值 - 当前字符数值，更新成对指针；
    // 2. 不可成对：直接去当前字符对应数值进行答案更新；
    public int romanToInt(String s) {
        Map<Character, Integer> c2Num = new HashMap<>();
        c2Num.put('I', 1);
        c2Num.put('V', 5);
        c2Num.put('X', 10);
        c2Num.put('L', 50);
        c2Num.put('C', 100);
        c2Num.put('D', 500);
        c2Num.put('M', 1000);

        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (i + 1 < n && c2Num.get(s.charAt(i + 1)) > c2Num.get(s.charAt(i))) {
                ans += c2Num.get(s.charAt(i + 1)) - c2Num.get(s.charAt(i));
                i++;
            } else {
                ans += c2Num.get(s.charAt(i));
            }
        }
        return ans;
    }
}
