package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/count-common-words-with-one-occurrence/
 *
 * @author songhuilong  @date 2022/9/29
 */
public class CountCommonWordsWithOneOccurrence {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> word2Cnt1 = new HashMap<>();
        for (String word : words1) {
            word2Cnt1.put(word, word2Cnt1.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> word2Cnt2 = new HashMap<>();
        for (String word : words2) {
            word2Cnt2.put(word, word2Cnt2.getOrDefault(word, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<String, Integer> entry : word2Cnt1.entrySet()) {
            String word = entry.getKey();
            Integer cnt = entry.getValue();
            if (cnt == 1 && word2Cnt2.containsKey(word) && word2Cnt2.get(word) == 1) {
                ans++;
            }
        }
        return ans;
    }

    private void calcCnt(String[] words, Map<String, Integer> word2Cnt) {
        for (String word : words) {
            word2Cnt.put(word, word2Cnt.getOrDefault(word, 0) + 1);
        }
    }
}
