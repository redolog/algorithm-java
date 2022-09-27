package com.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/check-permutation-lcci/
 *
 * @author DragonSong  @date 2022/9/27
 */
public class CheckPermutationLcci {

    static class SortSolution {
        /**
         * 排序时间复杂度：O(n*logn)
         * 空间复杂度：开辟了字符串对应字符数组，O(n)
         */
        public boolean checkPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            // i表示arr1遍历位置，j表示arr2遍历位置
            int i = 0, j = 0;
            while (i < arr1.length) {
                if (arr1[i++] != arr2[j++]) {
                    return false;
                }
            }
            return true;
        }
    }

    static class MapSolution {
        /**
         * 只要保证每个字符串中字符计数一致，就可以互相排列后相等
         * 同理也可以排序
         * <p>
         * 时间复杂度：O(n)
         * 空间复杂度：map为额外空间开销，O(n)
         */
        public boolean checkPermutation(String s1, String s2) {
            Map<Character, Integer> c2Cnt = new HashMap<>();
            for (char c : s1.toCharArray()) {
                c2Cnt.put(c, c2Cnt.getOrDefault(c, 0) + 1);
            }
            for (char c : s2.toCharArray()) {
                c2Cnt.put(c, c2Cnt.getOrDefault(c, 0) - 1);
            }
            for (Map.Entry<Character, Integer> entry : c2Cnt.entrySet()) {
                if (entry.getValue() != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
