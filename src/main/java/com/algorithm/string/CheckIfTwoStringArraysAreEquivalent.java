package com.algorithm.string;

/**
 * https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/
 *
 * @author songhuilong  @date 2022/11/1
 */
public class CheckIfTwoStringArraysAreEquivalent {

    static class StringJoinSolution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            return String.join("", word1).equals(String.join("", word2));
        }
    }

    static class TwoPointerSolution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            // i遍历word1数组、字符串；j遍历word2数组、字符串；
            // i1遍历数组、i2遍历字符串；
            int i1 = 0, i2 = 0, j1 = 0, j2 = 0, n1 = word1.length, n2 = word2.length;
            while (i1 != n1 && j1 != n2) {
                if (word1[i1].charAt(i2) != word2[j1].charAt(j2)) {
                    return false;
                }
                if (i2 == word1[i1].length() - 1) {
                    // 当前单词已遍历完，换到下一个单词
                    i2 = 0;
                    i1++;
                } else {
                    i2++;
                }
                if (j2 == word2[j1].length() - 1) {
                    // 当前单词已遍历完，换到下一个单词
                    j2 = 0;
                    j1++;
                } else {
                    j2++;
                }
            }
            return i1 == n1 && j1 == n2;
        }
    }
}
