package com.algorithm.string;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-first-palindromic-string-in-the-array/
 *
 * @author DragonSong  @date 2022/11/12
 */
public class FindFirstPalindromicStringInTheArray {

    /**
     * 依次逐个判断是否为回文串
     * 判断回文串：双指针双向奔赴
     */
    public String firstPalindrome(String[] words) {
        return Arrays.stream(words)
                .filter(this::isPalindrome)
                .findFirst()
                .orElse("")
                ;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
