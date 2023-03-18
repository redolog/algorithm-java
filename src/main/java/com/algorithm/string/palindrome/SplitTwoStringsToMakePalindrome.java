package com.algorithm.string.palindrome;

/**
 * https://leetcode.cn/problems/split-two-strings-to-make-palindrome/
 *
 * @author songhuilong001  @date 2023/3/18
 */
public class SplitTwoStringsToMakePalindrome {

    public boolean checkPalindromeFormation(String a, String b) {
        // 1. a/b 存在回文串
        // 2. a前缀拼接b后缀为回文串
        // 3. b前缀拼接a后缀为回文串
        return validPalindrome(a, 0, a.length() - 1) || validPalindrome(b, 0, b.length() - 1) || check(a, b) || check(b, a);
    }

    private boolean check(String a, String b) {
        int n = a.length();
        int l = 0, r = n - 1;

        while (l < r) {
            if (a.charAt(l) != b.charAt(r)) {
                break;
            }
            l++;
            r--;
        }
        // 最终拼接串取a的中间还是b的中间均可
        return validPalindrome(a, l, r) || validPalindrome(b, l, r);
    }

    private boolean validPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    private boolean validPalindrome2(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
