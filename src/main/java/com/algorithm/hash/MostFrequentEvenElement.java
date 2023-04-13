package com.algorithm.hash;

import jdk.nashorn.internal.ir.IfNode;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/most-frequent-even-element/">2404. 出现最频繁的偶数元素</a>
 *
 * @author songhuilong  @date 2023/4/13
 */
public class MostFrequentEvenElement {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> num2Freq = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                int freq = num2Freq.getOrDefault(num, 0) + 1;
                num2Freq.put(num, freq);

                maxFreq = Math.max(maxFreq, freq);
            }
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : num2Freq.entrySet()) {
            Integer num = entry.getKey();
            Integer freq = entry.getValue();
            if (freq != maxFreq) {
                continue;
            }
            if (ans == -1 || num < ans) {
                ans = num;
            }
        }
        return ans;
    }
}
