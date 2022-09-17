package com.algorithm.string.subString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/largest-substring-between-two-equal-characters/
 *
 * @author DragonSong  @date 2022/9/17
 */
public class LargestSubstringBetweenTwoEqualCharacters {

    /**
     * 记录每个字符出现过的所有位置
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        Map<Character, List<Integer>> c2Idxes = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            c2Idxes.computeIfAbsent(c, k -> new ArrayList<>());
            List<Integer> idxes = c2Idxes.get(c);
            idxes.add(i);

            if (idxes.size() > 1) {
                ans = Math.max(ans, idxes.get(idxes.size() - 1) - idxes.get(0) - 1);
            }
        }
        return ans;
    }

    /**
     * 记录每个字符第一次出现的位置
     */
    public int maxLengthBetweenEqualCharacters2(String s) {
        int ans = -1;
        Map<Character, Integer> c2FirstIdx = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c2FirstIdx.containsKey(c)) {
                ans = Math.max(ans, i - c2FirstIdx.get(c) - 1);
            } else {
                c2FirstIdx.put(c, i);
            }
        }
        return ans;
    }

}
