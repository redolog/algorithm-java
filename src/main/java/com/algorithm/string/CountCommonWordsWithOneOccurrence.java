package com.algorithm.string;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/count-common-words-with-one-occurrence/
 *
 * @author songhuilong  @date 2022/9/29
 */
public class CountCommonWordsWithOneOccurrence {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> word2Cnt1 = Arrays.stream(words1)
                // 元素为key，value为1，冲突时int累加
                .collect(Collectors.toMap(word -> word, k -> 1, Integer::sum));
        Map<String, Integer> word2Cnt2 = Arrays.stream(words2)
                // 同上
                .collect(Collectors.toMap(word -> word, k -> 1, Integer::sum));
        return (int) word2Cnt1.entrySet().stream()
                // words1 中cnt为1，并且words2中存在的word，cnt为1
                .filter(entry -> entry.getValue() == 1 && word2Cnt2.containsKey(entry.getKey()) && word2Cnt2.get(entry.getKey()) == 1)
                // 计数
                .count();
    }
}
