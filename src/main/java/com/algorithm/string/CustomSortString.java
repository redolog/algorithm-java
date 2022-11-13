package com.algorithm.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/custom-sort-string/
 *
 * @author songhuilong001  @date 2022/11/13
 */
public class CustomSortString {

    public String customSortString(String order, String s) {
        int n = order.length();
        // 所有字符唯一，使用数组记录其出现的下标，数组默认赋值都为0（默认表示了某个字符未出现，不计入排序规则）
        int[] c2Idx = new int[26];
        for (int i = 0; i < n; i++) {
            c2Idx[order.charAt(i) - 'a'] = i;
        }
        int m = s.length();
        Character[] cArr = new Character[m];
        for (int i = 0; i < m; i++) {
            cArr[i] = s.charAt(i);
        }
        Arrays.sort(cArr, Comparator.comparingInt(c -> c2Idx[c - 'a']));
        StringBuilder builder = new StringBuilder();
        for (Character c : cArr) {
            builder.append(c);
        }
        return builder.toString();
    }
}
