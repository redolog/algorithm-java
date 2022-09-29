package com.algorithm.string.subString;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * <p>
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 *
 * @author songhuilong  @date 2022/9/29
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    /**
     * 设 haystack.len == m needle.len == n
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.toCharArray().length - needle.length() + 1; i++) {
            char startChar = haystack.charAt(i);
            if (startChar != needle.charAt(0)) {
                continue;
            }
            int j = 0;
            boolean allMatch = true;
            while (j < needle.length()) {
                if (needle.charAt(j) != haystack.charAt(j + i)) {
                    allMatch = false;
                    break;
                }
                j++;
            }
            if (allMatch) {
                return i;
            }
        }
        return -1;
    }
}
