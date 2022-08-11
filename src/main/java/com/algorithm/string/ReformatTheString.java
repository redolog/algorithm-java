package com.algorithm.string;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1417. 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * <p>
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * <p>
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * 示例 3：
 * <p>
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * 示例 4：
 * <p>
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * 示例 5：
 * <p>
 * 输入：s = "ab123"
 * 输出："1a2b3"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 * <p>
 * https://leetcode.cn/problems/reformat-the-string/
 *
 * @author dragonsong  @date 2022/8/11
 */
public class ReformatTheString {

    /*
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 34.94%
     * 的用户
     * 内存消耗：
     * 42.2 MB
     * , 在所有 Java 提交中击败了
     * 12.50%
     * 的用户
     * 通过测试用例：
     * 302 / 302
     */

    public String reformat(String s) {
        Queue<Character> digits = new ArrayDeque<>();
        Queue<Character> lowerCaseLetters = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                digits.offer(c);
            } else {
                lowerCaseLetters.offer(c);
            }
        }
        if (Math.abs(digits.size() - lowerCaseLetters.size()) > 1) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        if (digits.size() >= lowerCaseLetters.size()) {
            while (digits.size() > 0 || lowerCaseLetters.size() > 0) {
                if (digits.size() > 0) {
                    builder.append(digits.poll());
                }
                if (lowerCaseLetters.size() > 0) {
                    builder.append(lowerCaseLetters.poll());
                }
            }
        } else {
            while (digits.size() > 0 || lowerCaseLetters.size() > 0) {
                if (lowerCaseLetters.size() > 0) {
                    builder.append(lowerCaseLetters.poll());
                }
                if (digits.size() > 0) {
                    builder.append(digits.poll());
                }
            }
        }
        return builder.toString();
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    static class TwoPointer {
        public String reformat(String s) {
            int digitCnt = 0;
            int n = s.length();
            for (int i = 0; i < n; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    digitCnt++;
                }
            }
            int lowerCaseLetterCnt = n - digitCnt;
            if (Math.abs(digitCnt - lowerCaseLetterCnt) > 1) {
                return "";
            }
            // 双指针逐个遍历
            char[] arr = s.toCharArray();
            // direction true时，先放digit，一次处理两个字符
            boolean direction = digitCnt >= lowerCaseLetterCnt;
            // i指向前序下标，j指向后序下标
            for (int i = 0, j = 1; i < n; i += 2) {
                // i指向的字符不符合 数字靠前或字母靠前，j找到与i相反的字符，交换
                if (direction != Character.isDigit(arr[i])) {
                    while (direction != Character.isDigit(arr[j])) {
                        j += 2;
                    }
                    char tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }

            return new String(arr);
        }
    }

}
