package com.algorithm.string.subSequence;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 * <p>
 * https://leetcode.cn/problems/is-subsequence/
 *
 * @author dragonsong  @date 2022/8/6
 */
public class IsSubSequence {

    public boolean isSubsequence(String s, String t) {
        // i表示s遍历下标
        int i = 0;
        // j表示t遍历下标
        int j = 0;
        while (i < s.length() && j < t.length()) {
            while (j < t.length() && t.charAt(j) != s.charAt(i)) {
                j++;
            }
            i++;
            j++;
        }
        return i == s.length() && j <= t.length();
    }

    public boolean isSubsequence2(String s, String t) {
        // i表示s遍历下标
        int i = 0;
        // j表示t遍历下标
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
