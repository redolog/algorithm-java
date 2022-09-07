package com.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/rearrange-spaces-between-words/
 *
 * @author songhuilong  @date 2022/9/7
 */
public class RearrangeSpacesBetweenWords {

    public String reorderSpaces(String text) {
        char[] arr = text.toCharArray();
        int wordCnt = 0, spaceCnt = 0, i = 0, n = arr.length;
        List<String> wordList = new ArrayList<>();
        while (i < n) {
            if (arr[i] == ' ') {
                spaceCnt++;
                i++;
            } else {
                // 字母
                StringBuilder builder = new StringBuilder();
                while (i < n && arr[i] != ' ') {
                    builder.append(arr[i]);
                    i++;
                }
                wordCnt++;
                wordList.add(builder.toString());
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int j = 0; j < wordCnt; j++) {
            ans.append(wordList.get(j));
            // 最后一个单词后在外部判断是否追加空格
            if (j == wordCnt - 1) {
                break;
            }
            for (int s = 0; s < spaceCnt / (wordCnt - 1); s++) {
                ans.append(' ');
            }
        }

        // 判断只有单词的情况，避免除以0
        for (int j = 0; j < (wordCnt == 1 ? spaceCnt : (spaceCnt % (wordCnt - 1))); j++) {
            ans.append(' ');
        }

        return ans.toString();
    }
}
