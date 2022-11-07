package com.algorithm.string;

/**
 * https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 *
 * @author DragonSong  @date 2022/11/8
 */
public class CountTheNumberOfConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        int[] letterCnt = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            letterCnt[allowed.charAt(i) - 'a']++;
        }

        int ans = 0;
        for (String word : words) {
            if (isConsistent(letterCnt, word)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isConsistent(int[] letterCnt, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (letterCnt[word.charAt(i) - 'a'] == 0) {
                return false;
            }
        }
        return true;
    }
}
