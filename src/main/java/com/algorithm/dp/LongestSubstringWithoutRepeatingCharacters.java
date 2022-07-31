package com.algorithm.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/submissions/
 *
 * @author dragonsong  @date 2022/7/31
 */
public class LongestSubstringWithoutRepeatingCharacters {

    static class TwoPointer {
        /*
         * 执行用时：
         * 5 ms
         * , 在所有 Java 提交中击败了
         * 60.27%
         * 的用户
         * 内存消耗：
         * 41.7 MB
         * , 在所有 Java 提交中击败了
         * 40.59%
         * 的用户
         * 通过测试用例：
         * 987 / 987
         */

        /**
         * 滑动窗口，双指针
         * l r指针
         * - l逐步右移，表示当前窗口内起点，窗口内维护无重复字符子串
         * - r在窗口内右移，碰到重复字符时停止
         * - set记录窗口内的字符
         */
        public int lengthOfLongestSubstring(String s) {
            int ans = 0;
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int r = 0;
            for (int l = 0; l < n; l++) {
                // 除了第一轮，后续每次先删除l对应字符
                if (l != 0) {
                    set.remove(s.charAt(l - 1));
                }
                // r右移
                while (r < n && !set.contains(s.charAt(r))) {
                    set.add(s.charAt(r));
                    r++;
                }
                ans = Math.max(ans, r - l);
            }

            return ans;
        }

        /*
         * 执行用时：
         * 4 ms
         * , 在所有 Java 提交中击败了
         * 86.61%
         * 的用户
         * 内存消耗：
         * 41.2 MB
         * , 在所有 Java 提交中击败了
         * 85.82%
         * 的用户
         * 通过测试用例：
         * 987 / 987
         */
        public int lengthOfLongestSubstring2(String s) {
            int ans = 0;
            int n = s.length();
            // 记录字符最新位置
            Map<Character, Integer> c2Idx = new HashMap<>();
            int l = 0;
            for (int r = 0; r < n; r++) {
                char currC = s.charAt(r);
                if (c2Idx.containsKey(currC)) {
                    // 碰到了重复字符，左指针可跳跃到重复字符的上一个位置+1
                    // 如果l之前的值比当前重复字符+1更小，说明之前已经碰到过别的重复字符，需要取更右侧的值，跳过前序已经判过重的位置
                    l = Math.max(c2Idx.get(currC) + 1, l);
                }
                ans = Math.max(ans, r - l + 1);
                c2Idx.put(currC, r);
            }
            return ans;
        }
    }

    static class DP {
        /*
         * 执行用时：
         * 11 ms
         * , 在所有 Java 提交中击败了
         * 18.28%
         * 的用户
         * 内存消耗：
         * 42 MB
         * , 在所有 Java 提交中击败了
         * 13.77%
         * 的用户
         * 通过测试用例：
         * 987 / 987
         */

        /**
         * dp[i]表示s[i]结尾的无重复字符的最长子串长度
         * dp[0]==1
         * max=max(dp[0,n-1])
         * set记录字符是否有出现过
         * dp[i]= (s[i]出现过 ? s[i-1]==s[i] ? 1 : min(dp[i-1]+1,i-prevIdx) : dp[i - 1] + 1)
         */
        public int lengthOfLongestSubstring(String s) {

            if (s == null || s.length() == 0) {
                return 0;
            }

            int n = s.length();
            int[] dp = new int[n];
            dp[0] = 1;
            // 记录字符上一个下标
            Map<Character, Integer> c2Idx = new HashMap<>();
            c2Idx.put(s.charAt(0), 0);

            int max = 1;
            for (int i = 1; i < n; i++) {
                char currC = s.charAt(i);
                if (c2Idx.containsKey(currC)) {
                    dp[i] = s.charAt(i - 1) == currC ? 1 : (Math.min(dp[i - 1] + 1, i - c2Idx.get(currC)));
                } else {
                    dp[i] = dp[i - 1] + 1;
                }

                c2Idx.put(currC, i);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

}
