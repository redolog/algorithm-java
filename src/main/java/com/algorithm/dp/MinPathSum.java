package com.algorithm.dp;

/**
 * https://leetcode.cn/problems/0i0mDW/description/
 *
 * @author songhuilong  @date 2025/11/12
 */
public class MinPathSum {

    static class GridDPSolution {
        public int minPathSum(int[][] grid) {
            // 算法概述：
            // 题目限定每次只能向下或向右移动，可以枚举每个可能的路径，并记录各路径和，最终取最小值即可
            // 创建与grid相同大小的二维数组，用于记录每个位置的最小路径和
            // dp[r][c] 表示到达r行、c列的最小路径和，每个点的最小路径和仅需判定是从上、从左进入（因为题目限定了每次只能向下、向右移动）
            // dp[0][0] = grid[0][0]
            // dp[r][c] = Math.min(dp[r-1][c], dp[r][c-1]);
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            // 优先计算首行首列，仅依赖单行列的前序值
            // 首行
            for (int c = 1; c < n; c++) {
                dp[0][c] = dp[0][c - 1] + grid[0][c];
            }
            // 首列
            for (int r = 1; r < m; r++) {
                dp[r][0] = dp[r - 1][0] + grid[r][0];
            }

            for (int r = 1; r < m; r++) {
                for (int c = 1; c < n; c++) {
                    dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

}
