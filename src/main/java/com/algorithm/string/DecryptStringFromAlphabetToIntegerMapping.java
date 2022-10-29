package com.algorithm.string;

/**
 * https://leetcode.cn/problems/decrypt-string-from-alphabet-to-integer-mapping/
 *
 * @author DragonSong  @date 2022/10/29
 */
public class DecryptStringFromAlphabetToIntegerMapping {

    public String freqAlphabets(String s) {
        String charBase = "-abcdefghijklmnopqrstuvwxyz";
        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '#') {
                ans.insert(0, charBase.charAt(c - '0'));
            } else {
                ans.insert(0, charBase.charAt(Integer.parseInt(s.substring(i - 2, i))));
                i -= 2;
            }
        }
        return ans.toString();
    }
}
