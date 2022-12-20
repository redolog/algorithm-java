package com.algorithm.dataStructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 *
 * @author songhuilong  @date 2022/12/20
 */
public class MaximumNumberOfPairsInArray {

    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Boolean> num2Pair = new HashMap<>();
        int pairCnt = 0;
        for (int num : nums) {
            if (num2Pair.getOrDefault(num, false)) {
                pairCnt++;
            }
            num2Pair.put(num, !num2Pair.getOrDefault(num, false));
        }
        return new int[]{pairCnt, nums.length - pairCnt * 2};
    }
}
