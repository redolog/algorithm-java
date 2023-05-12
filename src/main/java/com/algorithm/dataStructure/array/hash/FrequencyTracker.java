package com.algorithm.dataStructure.array.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrequencyTracker {

    // 维护每个数据的频率 num2Freq
    // 同时维护频率对应数据集合 freq2Nums
    // 数据集合使用有序结构 or set，保证读写效率

    Map<Integer, Integer> num2Freq;
    Map<Integer, Set<Integer>> freq2Nums;

    public FrequencyTracker() {
        num2Freq = new HashMap<>();
        freq2Nums = new HashMap<>();
    }

    public void add(int number) {
        int freq = num2Freq.getOrDefault(number, 0) + 1;
        num2Freq.put(number, freq);
        freq2Nums.computeIfAbsent(freq, k -> new HashSet<>());
        freq2Nums.get(freq).add(number);
        if (freq2Nums.containsKey(freq - 1)) {
            // 移除较低频率中的当前数据
            freq2Nums.get(freq - 1).remove(number);
        }
    }

    public void deleteOne(int number) {
        if (!num2Freq.containsKey(number)) {
            return;
        }
        int freq = num2Freq.get(number);
        num2Freq.remove(number);
        freq2Nums.get(freq).remove(number);
    }

    public boolean hasFrequency(int frequency) {
        return freq2Nums.containsKey(frequency) && !freq2Nums.get(frequency).isEmpty();
    }
}
