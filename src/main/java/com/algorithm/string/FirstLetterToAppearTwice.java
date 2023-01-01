package com.algorithm.string;

/**
 * https://leetcode.cn/problems/first-letter-to-appear-twice/
 *
 * @author songhuilong001  @date 2023/1/1
 */
public class FirstLetterToAppearTwice {

    static class MapSolution {
        /**
         * 开辟一个26长度的数组计数，实现基本的hashmap，出现字符计数为2时，返回
         * 时间：O(n)
         * 空间：O(26)
         */
        public char repeatedCharacter(String s) {
            int[] c2Cnt = new int[26];
            int n = s.length();
            for (int i = 0; i < n; i++) {
                c2Cnt[s.charAt(i) - 'a']++;
                if (c2Cnt[s.charAt(i) - 'a'] == 2) {
                    return s.charAt(i);
                }
            }
            return ' ';
        }
    }

    static class BitSolution {
        /**
         * 题目所求仅需要标记26个状态，因此可以使用一个int32来进行位操作、状态判断
         * 时间：O(n)
         * 空间：O(1)
         */
        public char repeatedCharacter(String s) {
            int n = s.length(), int32 = 0;
            for (int i = 0; i < n; i++) {
                int offset = s.charAt(i) - 'a';
                if ((int32 & (1 << offset)) != 0) {
                    return s.charAt(i);
                }
                int32 |= (1 << offset);
            }
            return ' ';
        }
    }
}
