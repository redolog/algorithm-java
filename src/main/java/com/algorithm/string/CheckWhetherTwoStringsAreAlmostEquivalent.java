package com.algorithm.string;

/**
 * https://leetcode.cn/problems/check-whether-two-strings-are-almost-equivalent/
 *
 * @author DragonSong  @date 2022/11/15
 */
public class CheckWhetherTwoStringsAreAlmostEquivalent {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] letterFreq = new int[26];
        int n = word1.length();
        for (int i = 0; i < n; i++) {
            letterFreq[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            letterFreq[word2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (Math.abs(letterFreq[i]) > 3) {
                return false;
            }
        }
        return true;
    }
}
