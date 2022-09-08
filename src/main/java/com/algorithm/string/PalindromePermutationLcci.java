package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/palindrome-permutation-lcci/
 *
 * @author songhuilong  @date 2022/9/8
 */
public class PalindromePermutationLcci {

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> c2Cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            c2Cnt.put(c, c2Cnt.getOrDefault(c, 0) + 1);
        }
        // 统计奇数次字符的出现次数，超过一个奇数词频的字符，说明不能回文
        int oddCnt = 0;
        for (Map.Entry<Character, Integer> entry : c2Cnt.entrySet()) {
            int cnt = entry.getValue();
            if (cnt % 2 == 1) {
                oddCnt++;
            }
            if (oddCnt > 1) {
                return false;
            }
        }
        return true;
    }
}
