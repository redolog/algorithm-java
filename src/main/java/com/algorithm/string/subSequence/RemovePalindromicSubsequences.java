package com.algorithm.string.subSequence;

/**
 * https://leetcode.cn/problems/remove-palindromic-subsequences/
 *
 * @author songhuilong  @date 2023/3/2
 */
public class RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        return isPalindrome(s) ? 1 : 2;
    }

    public boolean isPalindrome(String s) {
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
