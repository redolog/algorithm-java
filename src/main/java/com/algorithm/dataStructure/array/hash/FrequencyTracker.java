package com.algorithm.dataStructure.array.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/frequency-tracker/
 *
 * @author songhuilong001  @date 2023/5/12
 */
public class FrequencyTracker {

    static class CntSolution {
        // 数据元素对应频率
        Map<Integer, Integer> num2Freq;
        // 频率对应数据量；由于数据操作仅存在 add/delete，每一次频率内数据要么多一个少一个，不存在其他信息获取需求，因此仅维护频率对应数据量即可
        Map<Integer, Integer> freq2Cnt;

        public CntSolution() {
            num2Freq = new HashMap<>();
            freq2Cnt = new HashMap<>();
        }

        public void add(int number) {
            int oldFreq = num2Freq.getOrDefault(number, 0);
            int newFreq = oldFreq + 1;

            num2Freq.put(number, newFreq);
            if (oldFreq > 0) {
                freq2Cnt.put(oldFreq, freq2Cnt.get(oldFreq) - 1);
            }
            freq2Cnt.put(newFreq, freq2Cnt.getOrDefault(newFreq, 0) + 1);
        }

        public void deleteOne(int number) {
            if (!num2Freq.containsKey(number)) {
                return;
            }
            int oldFreq = num2Freq.get(number);
            int newFreq = oldFreq - 1;
            if (newFreq == 0) {
                num2Freq.remove(number);
            } else {
                num2Freq.put(number, newFreq);
                freq2Cnt.put(newFreq, freq2Cnt.getOrDefault(newFreq, 0) + 1);
            }
            freq2Cnt.put(oldFreq, freq2Cnt.get(oldFreq) - 1);
        }

        public boolean hasFrequency(int frequency) {
            return freq2Cnt.containsKey(frequency) && freq2Cnt.get(frequency) > 0;
        }
    }

    static class SetSolution {

        /**
         * 维护每个数据的频率 num2Freq
         * 同时维护频率对应数据集合 freq2Nums
         * 数据集合使用有序结构 or set，保证读写效率
         */
        Map<Integer, Integer> num2Freq;
        Map<Integer, Set<Integer>> freq2Nums;

        public SetSolution() {
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
            if (freq - 1 > 0) {
                // 频率-1的情况
                num2Freq.put(number, freq - 1);
                freq2Nums.computeIfAbsent(freq - 1, k -> new HashSet<>());
                freq2Nums.get(freq - 1).add(number);
            }
        }

        public boolean hasFrequency(int frequency) {
            return freq2Nums.containsKey(frequency) && !freq2Nums.get(frequency).isEmpty();
        }
    }


}
