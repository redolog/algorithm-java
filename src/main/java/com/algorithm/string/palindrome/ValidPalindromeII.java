package com.algorithm.string.palindrome;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome-ii/">680. 验证回文串 II</a>
 *
 * @author songhuilong  @date 2023/4/6
 */
public class ValidPalindromeII {

    static class BF {
        /**
         * 粗暴解思路：依次遍历每个字符，判断将当前字符去掉后，字符串是否为回文串；
         * 遍历n次，每次判断是否为回文串遍历n个字符；
         * 整体时间复杂度：O(n^2)
         */
        public boolean validPalindrome(String s) {
            if (isPalindrome(s, 0, s.length() - 1, -1)) {
                return true;
            }
            int n = s.length();
            for (int i = 0; i < n; i++) {
                // 跳过i
                if (isPalindrome(s, 0, s.length() - 1, i)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isPalindrome(String s, int l, int r, int skipIdx) {
            if (s == null || s.length() == 0 || l == r) {
                return true;
            }
            while (l < r) {
                if (skipIdx != -1) {
                    if (l == skipIdx) {
                        l++;
                    }
                    if (r == skipIdx) {
                        r--;
                    }
                }
                if (s.charAt(l++) != s.charAt(r--)) {
                    return false;
                }
            }
            return true;
        }
    }

    static class TwoPointer {
        /**
         * 题干关键信息：
         * 1. 是回文串只有两种情况：
         * a. 原字符串本身就是个回文串；
         * b. 去掉一个字符后，剩下的字符串为回文串；
         * ---
         * 双指针解法思路：
         * 1. 按照原串就是回文串的判断过程来双指针双向奔赴；
         * 2. 当 s[l]!=s[r] 时，将 l、r分别跳过，判断剩下的串是否为回文串；
         * ---
         * 整体仅需遍历字符串一次，时间复杂度：O(n)
         */
        public boolean validPalindrome(String s) {
            int n = s.length(), l = 0, r = n - 1;

            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    // 此时分别尝试跳过 l、r
                    return check(s, l + 1, r) || check(s, l, r - 1);
                } else {
                    l++;
                    r--;
                }
            }
            return true;
        }

        private boolean check(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l++) != s.charAt(r--)) {
                    return false;
                }
            }
            return true;
        }
    }

}
