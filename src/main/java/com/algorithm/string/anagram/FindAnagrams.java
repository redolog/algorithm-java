package com.algorithm.string.anagram;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 *
 * @author songhuilong  @date 2025/11/6
 */
public class FindAnagrams {

    /**
     * 滑动窗口复杂度：
     * 时间：O(sn * pn) 仅需遍历一次s长度，每次窗口内判断p子串是否异位词
     * 空间：O(1) 仅维护常量
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 明确定义：
        // 1. 子串，一段字符串中连续的子序列；
        // 2. 异位词，总字符数相同，且各字符出现次序有差异；

        // 算法概述：
        // 维护p长度的窗口，向右逐步滑动窗口，每次挪动时更新窗口指针 && 词频；
        // 同时维护窗口内的词频（单字符频次），当词频与p相同时，说明窗口内子串为异位词；
        // 由于仅包含小写字母，因此可以使用 int[26] 维护词频；

        int[] pFreArr = new int[26];
        for (char c : p.toCharArray()) {
            pFreArr[c - 'a']++;
        }

        int[] sFreArr = new int[26];

        int sn = s.length();
        int pn = p.length();
        int l = 0;
        int r = l;

        List<Integer> ans = new ArrayList<>();

        for (; r < sn; l++) {
            // 窗口右区间计数词频
            while (r < l + pn && r < sn) {
                sFreArr[s.charAt(r) - 'a']++;
                r++;
            }
            if (sameFreq(sFreArr, pFreArr)) {
                ans.add(l);
            }
            // 窗口左区间计数词频
            sFreArr[s.charAt(l) - 'a']--;
        }

        return ans;
    }

    private boolean sameFreq(int[] sFreArr, int[] pFreArr) {
        int n = sFreArr.length;
        for (int i = 0; i < n; i++) {
            if (sFreArr[i] != pFreArr[i]) {
                return false;
            }
        }
        return true;
    }
}
