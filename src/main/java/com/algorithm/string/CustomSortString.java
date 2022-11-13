package com.algorithm.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/custom-sort-string/
 *
 * @author songhuilong001  @date 2022/11/13
 */
public class CustomSortString {

    static class SortSolution {
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

    static class CntSortSolution {
        /**
         * order、s中只包含26个小写字母，可对s进行词频计数统计
         * 1. s词频统计
         * 2. 依次遍历order（保证了顺序），对词频大于0的进行 letter*cnt 拼接
         * 3. 针对order中没有，但是s中多出来的字符进行补充拼接
         * <p>
         * 设 order.length == n s.length == m
         * 时间：O(n+m+26)
         * 空间：O(26)
         */
        public String customSortString(String order, String s) {
            int n = order.length(), m = s.length();
            int[] wordFreq = new int[26];
            for (int i = 0; i < m; i++) {
                wordFreq[s.charAt(i) - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            //按order顺序拼接s与order的交集
            for (int i = 0; i < n; i++) {
                while (wordFreq[order.charAt(i) - 'a']-- > 0) {
                    builder.append(order.charAt(i));
                }
            }
            // 补充s中有但是order中没有，不需要讲究顺序的字母
            for (int i = 0; i < wordFreq.length; i++) {
                while (wordFreq[i]-- > 0) {
                    builder.append((char) (i + 'a'));
                }
            }
            return builder.toString();
        }
    }

}
