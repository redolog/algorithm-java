package com.algorithm.backtrack;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * <p>
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * @author DragonSong  @date 2022/7/10
 */
public class StringPermutation {

    /*
     * 执行用时：
     * 34 ms
     * , 在所有 Java 提交中击败了
     * 24.50%
     * 的用户
     * 内存消耗：
     * 46.7 MB
     * , 在所有 Java 提交中击败了
     * 36.49%
     * 的用户
     * 通过测试用例：
     * 52 / 52
     */

    public String[] permutation(String s) {
        Set<String> set = new HashSet<>();

        StringBuilder builder = new StringBuilder();
        boolean[] used = new boolean[s.length()];

        dfs(s, set, builder, used);

        String[] ans = new String[set.size()];
        int i = 0;
        for (String str : set) {
            ans[i++] = str;
        }
        return ans;
    }

    private void dfs(String s, Set<String> set, StringBuilder builder, boolean[] used) {
        if (builder.length() == s.length()) {
            set.add(builder.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            builder.append(s.charAt(i));

            dfs(s, set, builder, used);

            used[i] = false;
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
