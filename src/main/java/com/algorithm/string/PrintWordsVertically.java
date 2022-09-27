package com.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/print-words-vertically/
 *
 * @author DragonSong  @date 2022/9/27
 */
public class PrintWordsVertically {

    /**
     * 基本思路：分割每个单词，记录最长单词的位置
     */
    public List<String> printVertically(String s) {
        String[] wordArr = s.split(" ");
        // 最长单词位置
        int maxWordLen = Arrays.stream(wordArr)
                .max(Comparator.comparing(String::length))
                .orElse("")
                .length();

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < maxWordLen; i++) {
            StringBuilder builder = new StringBuilder();
            // j表示当前第j个单词位置
            for (String word : wordArr) {
                if (i < word.length()) {
                    builder.append(word.charAt(i));
                } else {
                    builder.append(" ");
                }
            }
            while (builder.charAt(builder.length() - 1) == ' ') {
                builder.deleteCharAt(builder.length() - 1);
            }
            ans.add(builder.toString());
        }
        return ans;
    }
}
