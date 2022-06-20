package com.algorithm.dataStructure.graph;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * <p>
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * <p>
 * 请问该机器人能够到达多少个格子？
 * <p>
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *
 * @author dragonsong  @date 2022/6/20
 */
public class RobotMovingCount {

    int cnt;

    /**
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 11.99%
     * 的用户
     * 内存消耗：
     * 38.1 MB
     * , 在所有 Java 提交中击败了
     * 83.88%
     * 的用户
     * 通过测试用例：
     * 49 / 49
     */
    public int movingCount(int m, int n, int k) {
        // 标记可达坐标
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int cnt = 1;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }

                // 当前坐标符合数位和条件 同时上一个坐标符合条件（上 或者 左）
                if (sum(row) + sum(col) <= k && ((row > 0 && visited[row - 1][col]) || (col > 0 && visited[row][col - 1]))) {
                    visited[row][col] = true;
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    /**
     * 使用dfs，标记每一次遍历的前序节点的状态
     */
    public int movingCountDfs(int m, int n, int k) {
        // 借用数组的特性，标记遍历过的节点状态
        boolean[][] visited = new boolean[m][n];
        cnt = 0;

        dfs(visited, m, n, k, 0, 0);

        return cnt;
    }

    private void dfs(boolean[][] visited, int m, int n, int k, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
            return;
        }

        if (sum(row) + sum(col) > k) {
            return;
        }
        visited[row][col] = true;
        ++cnt;
        dfs(visited, m, n, k, row + 1, col);
        dfs(visited, m, n, k, row, col + 1);
    }

    public int sum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }


}
