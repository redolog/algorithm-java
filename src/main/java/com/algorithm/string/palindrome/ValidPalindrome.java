package com.algorithm.string.palindrome;

/**
 * https://leetcode.cn/problems/valid-palindrome/
 * <p>
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 *
 * @author dragonsong  @date 2022/6/6
 */
public class ValidPalindrome {

    /**
     * 1. 边界条件：字符串空、长度为1时，为回文字符串；
     * 2. 递推公式：f(n)= char(begin)==char(end) && f(n-1)
     * 其中 n-1=n-begin-end
     */
    public boolean isPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return true;
        }
        // 回文begin对应的end下标
        int startIdx = 0;
        char startChar = Character.toLowerCase(s.charAt(startIdx));
        int endIdx = s.length() - 1;
        char endChar = Character.toLowerCase(s.charAt(endIdx));
        // 判断字符字母或数字
        while (!isLowerLetter(startChar) && !isDigit(startChar)) {
            ++startIdx;
            startChar = Character.toLowerCase(s.charAt(startIdx));
        }
        while (!isLowerLetter(endChar) && !isDigit(endChar)) {
            --endIdx;
            endChar = Character.toLowerCase(s.charAt(endIdx));
        }

        if (startIdx >= endIdx) {
            return true;
        }
        return startChar == endChar && isPalindrome(s.substring(startIdx + 1, endIdx));
    }

    public boolean isLowerLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public boolean isDigit(char c) {
        return c >= '1' && c <= '9';
    }

    public boolean isPalindromeTraverse(String s) {
        if (null == s || s.length() <= 1) {
            return true;
        }
        int startIdx = 0;
        int endIdx = s.length() - 1;
        while (startIdx < endIdx) {
            // 回文begin对应的end下标
            char startChar = Character.toLowerCase(s.charAt(startIdx));
            char endChar = Character.toLowerCase(s.charAt(endIdx));
            // 判断字符字母或数字
            while (!isLowerLetter(startChar) && !isDigit(startChar)) {
                ++startIdx;
                if (startIdx > endIdx || startIdx >= s.length() - 1) {
                    return true;
                }
                startChar = Character.toLowerCase(s.charAt(startIdx));
            }
            while (!isLowerLetter(endChar) && !isDigit(endChar)) {
                --endIdx;
                if (endIdx < startIdx) {
                    return true;
                }
                endChar = Character.toLowerCase(s.charAt(endIdx));
            }

            ++startIdx;
            --endIdx;
            if (startChar != endChar) {
                return false;
            }
        }
        return true;
    }

}
