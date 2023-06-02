package com.algorithm.dataStructure.array.diff;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/count-vowel-strings-in-ranges/">2559. Count Vowel Strings in Ranges</a>
 *
 * @author songhuilong  @date 2023/6/2
 */
public class CountVowelStringsInRanges {

    static Set<Character> vowelSet;

    static {
        vowelSet = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
    }

    static class DiffArraySolution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            int n = words.length;
            int[] diffArr = new int[n + 1];
            // O(n)
            // 先计算 [0,i] 区间的vowel单词数
            for (int i = 0; i < n; i++) {
                diffArr[i + 1] = calcVowelString(words[i]) + diffArr[i];
            }
            // O(m)
            int m = queries.length;
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                int[] query = queries[i];
                int l = query[0], r = query[1];
                ans[i] = diffArr[r + 1] - diffArr[l];
            }
            return ans;
        }
    }

    static class BFSolution {
        /**
         * 暴力法超时
         * 时间复杂度：O(m*n)
         */
        public int[] vowelStrings(String[] words, int[][] queries) {
            int n = queries.length, j = 0;
            int[] ans = new int[n];
            for (int[] query : queries) {
                int l = query[0], r = query[1], vowelStrCnt = 0;
                for (int i = l; i <= r; i++) {
                    vowelStrCnt += calcVowelString(words[i]);
                }
                ans[j++] = vowelStrCnt;
            }
            return ans;
        }

    }

    private static int calcVowelString(String word) {
        if (vowelSet.contains(word.charAt(0)) && vowelSet.contains(word.charAt(word.length() - 1))) {
            return 1;
        }
        return 0;
    }
}
