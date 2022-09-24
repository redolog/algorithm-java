package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/isomorphic-strings/
 *
 * @author DragonSong  @date 2022/9/24
 */
public class IsomorphicStrings {

    static class OneMap {
        /**
         * 使用一个map，标记 当前字符的位置
         * put字符时返回上一次的下标，如果 put(sChar)!=put(tChar) 说明两个字符串非同构
         */
        public boolean isIsomorphic(String s, String t) {
            Map<String, Integer> c2Idx = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char sChar = s.charAt(i), tChar = t.charAt(i);
                if (notEqualsInt(c2Idx.put("s_" + sChar, i), c2Idx.put("t_" + tChar, i))) {
                    return false;
                }
            }
            return true;
        }

        private boolean equalsInt(Integer a, Integer b) {
            if (a == null) {
                return b == null;
            }
            return a.equals(b);
        }

        private boolean notEqualsInt(Integer a, Integer b) {
            return !equalsInt(a, b);
        }
    }

    static class TwoMap {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> s2T = new HashMap<>();
            Map<Character, Character> t2S = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char sChar = s.charAt(i), tChar = t.charAt(i);
                if (s2T.containsKey(sChar) && s2T.get(sChar) != tChar) {
                    return false;
                }
                if (t2S.containsKey(tChar) && t2S.get(tChar) != sChar) {
                    return false;
                }
                s2T.put(sChar, tChar);
                t2S.put(tChar, sChar);
            }
            return true;
        }
    }


}
