package com.algorithm.string;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/longest-common-prefix/
 *
 * @author dragonsong  @date 2022/7/16
 */
public class LongestCommonPrefix {

    static class Simulation {
        /*
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 69.68%
         * 的用户
         * 内存消耗：
         * 39.3 MB
         * , 在所有 Java 提交中击败了
         * 61.24%
         * 的用户
         * 通过测试用例：
         * 124 / 124
         */
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0 || strs[0].equals("")) {
                return "";
            }

            if (strs.length == 1) {
                return strs[0];
            }

            int prefixIdx = -1;
            String baseStr = strs[0];

            whileStart:
            while (true) {
                int nextPrefixIdx = prefixIdx + 1;
                for (int i = 1; i < strs.length; i++) {
                    if (nextPrefixIdx == strs[i].length() || nextPrefixIdx == baseStr.length() || strs[i].charAt(nextPrefixIdx) != baseStr.charAt(nextPrefixIdx)) {
                        break whileStart;
                    }
                }
                prefixIdx = nextPrefixIdx;
            }
            return prefixIdx == -1 ? "" : baseStr.substring(0, prefixIdx + 1);
        }
    }


}
