package com.algorithm.string;

/**
 * 1961. 检查字符串是否为数组前缀
 * 给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。
 * <p>
 * 字符串 s 要成为 words 的 前缀字符串 ，需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 words.length 。
 * <p>
 * 如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "iloveleetcode", words = ["i","love","leetcode","apples"]
 * 输出：true
 * 解释：
 * s 可以由 "i"、"love" 和 "leetcode" 相连得到。
 * 示例 2：
 * <p>
 * 输入：s = "iloveleetcode", words = ["apples","i","love","leetcode"]
 * 输出：false
 * 解释：
 * 数组的前缀相连无法得到 s 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * 1 <= s.length <= 1000
 * words[i] 和 s 仅由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/check-if-string-is-a-prefix-of-array/
 *
 * @author dragonsong  @date 2022/7/16
 */
public class CheckIfAStringIsAPrefixOfArray {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 97.04%
     * 的用户
     * 通过测试用例：
     * 349 / 349
     */

    public boolean isPrefixString(String s, String[] words) {
        int strIdx = 0;

        if (strIdx == s.length()) {
            return true;
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (strIdx == s.length() && j != 0) {
                    return false;
                }
                if (strIdx == s.length()) {
                    return true;
                }

                if (words[i].charAt(j) != s.charAt(strIdx)) {
                    return false;
                }
                ++strIdx;
            }
        }
        return strIdx == s.length();

    }
}
