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

    static class BigMapPutPrevIdx {
        /**
         * 使用同一个map，存储元素值对应位置i
         * 利用java的特性，我们的map可以存 <Object,Integer>
         * map.put 返回key对应上一个value，也就是重复key返回上一次的位置，pattern、s中的子串key对应上一个位置不同时，说明不匹配
         * <p>
         * 示例：
         * 1. pattern = "abba", s = "dog cat cat dog"
         * a跟dog首次添加时，put返回null，第二次添加时均返回对应i位置
         * <p>
         * 2. pattern = "aaaa", s = "dog cat cat dog"
         * a跟dog首次添加时，put返回null
         * a第二次put时返回0，而cat put时返回null，说明cat第一次处理，而a已经第二次了，不匹配
         */
        public boolean wordPattern(String pattern, String s) {
            // 映射 子串->遍历位置
            Map<Object, Integer> p2PrevIdx = new HashMap<>();
            String[] arr = s.split(" ");
            if (pattern.length() != arr.length) {
                return false;
            }
            int i = 0;
            for (String ss : arr) {
                char currC = pattern.charAt(i);
                if (notEqualsInt(p2PrevIdx.put(ss, i), (p2PrevIdx.put(currC, i)))) {
                    return false;
                }
                i++;
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
        /**
         * 两个匹配映射使用两个map，在一次循环中同步判断
         */
        public boolean wordPattern(String pattern, String s) {
            // 映射 pattern单字符->s子串
            Map<Character, String> p2Str = new HashMap<>();
            // 映射 s子串->pattern单字符
            Map<String, Character> str2P = new HashMap<>();
            // i遍历pattern中每个字符
            int i = 0;
            String[] arr = s.split(" ");
            if (pattern.length() != arr.length) {
                return false;
            }
            for (String ss : arr) {
                char currC = pattern.charAt(i);
                if (p2Str.containsKey(currC) && !ss.equals(p2Str.get(currC))) {
                    return false;
                }
                if (str2P.containsKey(ss) && currC != (str2P.get(ss))) {
                    return false;
                }
                p2Str.put(currC, ss);
                str2P.put(ss, currC);
                i++;
            }
            return true;
        }
    }

    static class ExtractMatch {
        /**
         * 提取公共的match方法
         */
        public boolean wordPattern(String pattern, String s) {
            String[] sArr = s.split(" ");
            if (pattern.length() != sArr.length) {
                return false;
            }
            char[] patterArr = pattern.toCharArray();
            String[] patternStrArr = new String[patterArr.length];
            for (int i = 0; i < patterArr.length; i++) {
                patternStrArr[i] = String.valueOf(patterArr[i]);
            }
            return match(patternStrArr, sArr) && match(sArr, patternStrArr);
        }

        private boolean match(String[] patternArr, String[] sArr) {
            Map<String, String> p2Str = new HashMap<>();
            // i遍历pattern中每个字符
            int i = 0;
            for (String ss : sArr) {
                String currC = String.valueOf(patternArr[i]);
                if (p2Str.containsKey(currC) && !ss.equals(p2Str.get(currC))) {
                    return false;
                }
                p2Str.put(currC, ss);
                i++;
            }
            return true;
        }
    }


}
