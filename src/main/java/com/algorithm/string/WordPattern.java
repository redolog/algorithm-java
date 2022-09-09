package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/word-pattern/
 *
 * @author songhuilong  @date 2022/9/9
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<String, String> p2Str = new HashMap<>();
        // i遍历pattern中每个字符
        int i = 0;
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        for (String ss : arr) {
            String currC = String.valueOf(pattern.charAt(i));
            if (p2Str.containsKey(currC) && !ss.equals(p2Str.get(currC))) {
                return false;
            }
            p2Str.put(currC, ss);
            i++;
        }
        p2Str.clear();
        i = 0;
        for (String ss : arr) {
            String currC = String.valueOf(pattern.charAt(i));
            if (p2Str.containsKey(ss) && !currC.equals(p2Str.get(ss))) {
                return false;
            }
            p2Str.put(ss, currC);
            i++;
        }
        return true;
    }
}
