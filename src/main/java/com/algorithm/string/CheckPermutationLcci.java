package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/check-permutation-lcci/
 *
 * @author DragonSong  @date 2022/9/27
 */
public class CheckPermutationLcci {

    /**
     * 只要保证每个字符串中字符计数一致，就可以互相排列后相等
     * 同理也可以排序
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
