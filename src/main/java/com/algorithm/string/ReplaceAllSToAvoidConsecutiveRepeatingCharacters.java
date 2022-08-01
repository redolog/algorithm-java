package com.algorithm.string;

/**
 * 1576. 替换所有的问号
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * <p>
 * 注意：你 不能 修改非 '?' 字符。
 * <p>
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * <p>
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "?zs"
 * 输出："azs"
 * 解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
 * 示例 2：
 * <p>
 * 输入：s = "ubv?w"
 * 输出："ubvaw"
 * 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * <p>
 * s 仅包含小写英文字母和 '?' 字符
 * <p>
 * https://leetcode.cn/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 *
 * @author dragonsong  @date 2022/8/1
 */
public class ReplaceAllSToAvoidConsecutiveRepeatingCharacters {

    /*
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41.1 MB
     * , 在所有 Java 提交中击败了
     * 91.64%
     * 的用户
     * 通过测试用例：
     * 776 / 776
     */

    public String modifyString(String s) {
        if (s.length() < 2) {
            return s.equals("?") ? "a" : s;
        }

        StringBuilder builder = new StringBuilder();
        int prev = -1, curr = 0, next = 1;
        for (; curr < s.length(); curr++, prev++, next++) {
            builder.append(s.charAt(curr) == '?' ? newChar(prev, next, s, builder) : s.charAt(curr));
        }
        return builder.toString();
    }

    public char newChar(int prev, int next, String s, StringBuilder builder) {
        prev = prev == -1 ? -1 : builder.charAt(prev) - 'a';
        next = next == s.length() ? -1 : s.charAt(next) - 'a';

        for (int i = 0; i < 26; i++) {
            if (i != prev && i != next) {
                return (char) (i + 'a');
            }
        }
        return ' ';
    }
}
