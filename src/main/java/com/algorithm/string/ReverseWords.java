package com.algorithm.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * <p>
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 *
 * @author dragonsong  @date 2022/7/1
 */
public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();
        // 连续空白字符分隔
        String[] words = s.split("\\s+");
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 74.16%
     * 的用户
     * 内存消耗：
     * 41.3 MB
     * , 在所有 Java 提交中击败了
     * 58.05%
     * 的用户
     * 通过测试用例：
     * 25 / 25
     */
    public String reverseWordsTwoPointer(String s) {
        s = s.trim();
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int i = len - 1;
        // 倒序拼装字符串
        StringBuilder builder = new StringBuilder();
        while (i >= 0) {
            // 跳过空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int start = i;
            // 找单词
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            int end = i;
            // 拼接单词、一个空格
            builder.append(s, end + 1, start + 1).append(" ");

            // 跳过空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
        }
        // 去掉最后一个空格
        builder.deleteCharAt(builder.lastIndexOf(" "));
        return builder.toString();
    }

}
