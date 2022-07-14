package com.algorithm.dp;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * <p>
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * @author dragonsong  @date 2022/7/14
 */
public class GiftMaxValue {

    /*
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 97.87%
     * 的用户
     * 内存消耗：
     * 44.5 MB
     * , 在所有 Java 提交中击败了
     * 5.11%
     * 的用户
     * 通过测试用例：
     * 61 / 61
     */

    /**
     * |   要素  |   |
     * |  ----  | ----  |
     * |  状态表示  | `dp[r][c]`表示以`grid[r][c]`结尾的礼物最大的价值；  |
     * |  阶段划分  | 子序列结尾；  |
     * |  转移方程  | `dp[r][c]=Max(dp[r-1][c],dp[r][c-1])+grid[r][c] (0<=r<m 0<=c<n)`，其中`r`表示行下标、`c`表示列下标；  |
     * |  边界  | r==0 || c==0时，dp[r][c]=grid[r][c]叠加，dp[0][0]=grid[0][0]  |
     * |  目标  | `Max(dp[r][c]) (0<=r<m 0<=c<n)`，题干中给定每个单元格值为正，因此 dp[m-1][n-1]即为最大价值；  |
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // 第一个点仅包含自身
        dp[0][0] = grid[0][0];
        // 初始化第0行dp
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 初始化第0列dp
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 从第一行第一列开始
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = grid[row][col] + Math.max(dp[row - 1][col], dp[row][col - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
