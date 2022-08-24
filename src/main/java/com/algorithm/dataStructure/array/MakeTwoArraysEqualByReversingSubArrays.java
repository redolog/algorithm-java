package com.algorithm.dataStructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 *
 * @author dragonsong  @date 2022/8/24
 */
public class MakeTwoArraysEqualByReversingSubArrays {

    static class Sort {
        /**
         * 排序后比较两个数组
         * 时间复杂度： O(n*logn)
         * 空间复杂度： O(logn)
         */
        public boolean canBeEqual(int[] target, int[] arr) {
            Arrays.sort(target);
            Arrays.sort(arr);
            for (int i = 0; i < target.length; i++) {
                if (target[i] != arr[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Count {
        /**
         * 计数
         * 时间复杂度： O(n)
         * 空间复杂度： O(n)
         */
        public boolean canBeEqual(int[] target, int[] arr) {
            Map<Integer, Integer> num2Cnt = new HashMap<>();
            for (int t : target) {
                num2Cnt.put(t, num2Cnt.getOrDefault(t, 0) + 1);
            }
            for (int a : arr) {
                num2Cnt.put(a, num2Cnt.getOrDefault(a, 0) - 1);
            }
            return num2Cnt.values().stream().noneMatch(cnt -> cnt != 0);
        }
    }


}
