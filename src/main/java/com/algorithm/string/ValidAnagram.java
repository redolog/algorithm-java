package com.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/valid-anagram/
 *
 * @author songhuilong  @date 2022/10/14
 */
public class ValidAnagram {

    static class CntSolution {
        /**
         * 逐个计数
         */
        public boolean isAnagram(String s, String t) {
            Map<Object, Integer> c2Cnt = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                c2Cnt.merge(s.charAt(i), 1, Integer::sum);
            }

            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                c2Cnt.put(c, c2Cnt.getOrDefault(c, 0) - 1);
            }
            return c2Cnt.values().stream().noneMatch(cnt -> cnt != 0);
        }
    }

    static class SortSolution {
        public boolean isAnagram(String s, String t) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            char[] tArr = t.toCharArray();
            Arrays.sort(tArr);
            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] != tArr[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
