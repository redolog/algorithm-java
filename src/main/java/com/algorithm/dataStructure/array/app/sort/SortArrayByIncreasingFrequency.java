package com.algorithm.dataStructure.array.app.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 *
 * @author DragonSong  @date 2022/9/19
 */
public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> num2Cnt = new HashMap<>();
        for (int num : nums) {
            num2Cnt.put(num, num2Cnt.getOrDefault(num, 0) + 1);
        }
        // 按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序
        return Arrays.stream(nums).boxed()
                .sorted((a, b) -> {
                    int freqA = num2Cnt.get(a);
                    int freqB = num2Cnt.get(b);
                    if (freqA != freqB) {
                        return freqA - freqB;
                    }
                    return b - a;
                }).mapToInt(Integer::valueOf).toArray();
    }

}
