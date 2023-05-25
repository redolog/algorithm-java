package com.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/odd-string-difference/">2451. Odd String Difference</a>
 * <p>
 * Constraints:
 * <p>
 * 3 <= words.length <= 100
 * n == words[i].length
 * 2 <= n <= 20
 * words[i] consists of lowercase English letters.
 *
 * @author songhuilong  @date 2023/5/25
 */
public class OddStringDifference {

    static class StreamSolution {
        public String oddString(String[] words) {
            return Arrays.stream(words)
                    .collect(Collectors.groupingBy(word -> {
                        int n = word.length();
                        int[] diffArr = new int[n - 1];
                        for (int i = 1; i < n; i++) {
                            diffArr[i - 1] = word.charAt(i) - word.charAt(i - 1);
                        }
                        return Arrays.toString(diffArr);
                    }))
                    .values()
                    .stream()
                    .filter(groupWords -> groupWords.size() == 1)
                    .map(groupWords -> groupWords.get(0))
                    .findAny()
                    .orElse("");
        }
    }

    static class MapSolution {
        public String oddString(String[] words) {
            Map<String, Integer> diffKey2Cnt = new HashMap<>();
            Map<String, String> diffKey2Word = new HashMap<>();
            for (String word : words) {
                int n = word.length();
                int[] diffArr = new int[n - 1];
                for (int i = 1; i < n; i++) {
                    diffArr[i - 1] = word.charAt(i) - word.charAt(i - 1);
                }
                String diffKey = Arrays.toString(diffArr);
                diffKey2Cnt.put(diffKey, diffKey2Cnt.getOrDefault(diffKey, 0) + 1);
                diffKey2Word.put(diffKey, word);
            }

            for (Map.Entry<String, Integer> entry : diffKey2Cnt.entrySet()) {
                String diffKey = entry.getKey();
                Integer cnt = entry.getValue();
                if (cnt == 1) {
                    return diffKey2Word.get(diffKey);
                }
            }
            return "";
        }
    }


}
