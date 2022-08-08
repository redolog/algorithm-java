package com.algorithm.string;

/**
 * 1446. 连续字符
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * <p>
 * 请你返回字符串 s 的 能量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 示例 2：
 * <p>
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/consecutive-characters/
 *
 * @author dragonsong  @date 2022/8/8
 */
public class ConsecutiveCharacters {

    public int maxPower(String s) {
        int ans = 0;
        if (null == s || s.length() == 0) {
            return ans;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int l = i;
            while (i + 1 < n && s.charAt(i + 1) == s.charAt(i)) {
                i++;
            }
            // i最终挪动到了与 s[l]相同字符的最右
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
