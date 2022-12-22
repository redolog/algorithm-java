package com.algorithm.string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/most-common-word/
 *
 * @author songhuilong  @date 2022/12/22
 */
public class MostCommonWord {

    private static final Set<Character> SKIP_SET = new HashSet<Character>() {{
        add('!');
        add('?');
        add('\'');
        add(',');
        add(';');
        add('.');
        add(' ');
    }};

    public String mostCommonWord(String paragraph, String[] banned) {

        List<String> words = new ArrayList<>();
        for (int i = 0; i < paragraph.length(); i++) {
            if (SKIP_SET.contains(paragraph.charAt(i))) {
                continue;
            }

            StringBuilder builder = new StringBuilder();
            while (i < paragraph.length() && !SKIP_SET.contains(paragraph.charAt(i))) {
                builder.append(Character.toLowerCase(paragraph.charAt(i)));
                i++;
            }
            words.add(builder.toString());
        }

        Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());
        words = words.stream().filter(word -> !bannedSet.contains(word)).collect(Collectors.toList());

        Map<String, Integer> w2Cnt = new HashMap<>();
        int maxFreq = 0;
        for (String word : words) {
            int freq = w2Cnt.getOrDefault(word, 0) + 1;
            w2Cnt.put(word, freq);
            maxFreq = Math.max(maxFreq, freq);
        }
        for (String word : words) {
            if (w2Cnt.get(word) == maxFreq) {
                return word;
            }
        }
        return null;
    }
}
