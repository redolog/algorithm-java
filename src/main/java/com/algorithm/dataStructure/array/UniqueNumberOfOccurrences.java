package com.algorithm.dataStructure.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/unique-number-of-occurrences/
 *
 * @author DragonSong  @date 2022/9/18
 */
public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> num2Cnt = new HashMap<>();
        for (int num : arr) {
            num2Cnt.put(num, num2Cnt.getOrDefault(num, 0) + 1);
        }
        Set<Integer> cntSet = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : num2Cnt.entrySet()) {
            int cnt = entry.getValue();
            cntSet.add(cnt);
        }
        return num2Cnt.size() == cntSet.size();
    }
}
