package com.algorithm.string;

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
        return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
    }

    public boolean isPalindromeTraverse(String s) {
        if (null == s || s.length() <= 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

}
