package com.algorithm.string.anagram;

import java.util.*;
import java.util.stream.Collectors;


/**
 * https://leetcode.cn/problems/group-anagrams/
 *
 * @author songhuilong  @date 2025/11/5
 */
public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        // 字母异位词特征，同个字符频率相同，因此尝试用map维护字符串中的字符频率
        Map<String, List<String>> str2List = new HashMap<>();
        for (String str : strs) {
            // 词频
            int[] c2Cnt = new int[26];
            for (Character c : str.toCharArray()) {
                c2Cnt[c - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            int n = c2Cnt.length;
            // 此处不可使用原生map计数计算freqStr，因为map底层hash冲突后，链表写入顺序会导致同词频但是不同顺序的字符串code不同
            for (int i = 0; i < n; i++) {
                builder.append((char) (i + 'a'))
                        .append(c2Cnt[i]);
            }
            String freqStr = builder.toString();
            List<String> list = str2List.getOrDefault(freqStr, new ArrayList<>());
            list.add(str);
            str2List.put(freqStr, list);
        }
        return new ArrayList<List<String>>(str2List.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        return new ArrayList<>(
                Arrays.stream(strs)
                        .collect(Collectors.groupingBy(s -> {
                            // 将词频相同的字符串归并到一个组内
                            int[] c2Cnt = new int[26];
                            for (char c : s.toCharArray()) {
                                c2Cnt[c - 'a']++;
                            }
                            StringBuilder builder = new StringBuilder();
                            for (int i = 0; i < c2Cnt.length; i++) {
                                // 拼接为：字符 + 词频
                                builder.append((char) (i - 'a'))
                                        .append(c2Cnt[i]);
                            }
                            return builder.toString();
                        })).values()
        );
    }

}
