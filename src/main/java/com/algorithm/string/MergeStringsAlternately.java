package com.algorithm.string;

/**
 * https://leetcode.cn/problems/merge-strings-alternately/
 *
 * @author DragonSong  @date 2022/10/23
 */
public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            builder.append(word1.charAt(i));
            // word2有可能比word1短
            if (i < word2.length()) {
                builder.append(word2.charAt(i));
            }
        }
        if (word2.length() > word1.length()) {
            for (int i = word1.length(); i < word2.length(); i++) {
                builder.append(word2.charAt(i));
            }
        }
        return builder.toString();
    }
}
