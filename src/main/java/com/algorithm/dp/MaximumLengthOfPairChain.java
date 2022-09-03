package com.algorithm.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/
 *
 * @author DragonSong  @date 2022/9/3
 */
public class MaximumLengthOfPairChain {

    static class DP {
        /**
         * LIS 最长递增子序列DP解法
         *
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n)
         */
        public int findLongestChain(int[][] pairs) {
            int n = pairs.length;
            // dp[i] 表示 pairs[i] 结尾的链数最大长度
            int[] dp = new int[n];
            // 初始默认每个元素结尾的最长递增子序列长度为1，也就是只包含 pairs[i] 元素自身
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }

            // 使用pair[0]升序排序，
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    // j前序元素出现了比i严格小的情况
                    if (pairs[j][1] < pairs[i][0]) {
                        // 根据状态转移方程，我们的子问题连接时，前序有小于当前基准值的情况下，子问题解可以在前一个子问题的解上+1，dp[i]取 dp[i]/dp[j]+1 的更大值
                        dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                    }
                }
            }

            // 题目所求为我们定义的子问题最优值
            return dp[n - 1];
        }
    }

    static class Greedy {
        /**
         * 贪心：将pairs使用pair[1]即第二项排序；遍历，当前项pair[0]与prev（prevPair[1]）符合chain条件时，形成chain；
         * <p>
         * 时间复杂度：O(n + n*logn)
         * 空间复杂度：O(logn)
         */
        public int findLongestChain(int[][] pairs) {
            // 使用第二个数排序，遍历pairs
            // 用第一个数比较
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
            // Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
            int ans = 0;
            // 表示上一个pair[1]
            int prev = Integer.MIN_VALUE;
            for (int[] pair : pairs) {
                // 只要发现当前项与前一项能形成chain，就记录状态
                if (prev < pair[0]) {
                    ans++;
                    prev = pair[1];
                }
            }
            return ans;
        }
    }
}
