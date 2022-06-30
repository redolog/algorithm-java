package com.algorithm.dataStructure.matrix;

/**
 * 463. 岛屿的周长
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * <p>
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * https://leetcode.cn/problems/island-perimeter/
 *
 * @author dragonsong  @date 2022/6/30
 */
public class IslandPerimeter {

    /*
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 99.92%
     * 的用户
     * 内存消耗：
     * 42.4 MB
     * , 在所有 Java 提交中击败了
     * 21.22%
     * 的用户
     * 通过测试用例：
     * 5833 / 5833
     */

    /**
     * 整个网格被水完全包围，说明我们遍历grid，开始一定是先水，然后才陆地
     * 当进入陆地，可以对陆地计数，陆地挨着是陆地，说明 a陆地、b陆地接壤，对周长的贡献分别-1
     * 而挨着由于我们已经是遍历过左侧跟上侧，所以检查挨着需要向右、向下
     * <p>
     * 周长=4*陆地数-2*接壤数
     * 对陆地数、接壤数计数即可
     *
     * @param grid 网格图
     */
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int landCnt = 0;
        int borderCnt = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    landCnt++;
                    // 向右看相邻
                    if (col + 1 < n && grid[row][col + 1] == 1) {
                        borderCnt++;
                    }
                    // 向下看相邻
                    if (row + 1 < m && grid[row + 1][col] == 1) {
                        borderCnt++;
                    }
                }
            }
        }
        return 4 * landCnt - 2 * borderCnt;
    }

    /**
     * dfs的思路是：一杆子戳到底，如果戳到了陆地、水区的边界，说明是岛屿的边，那么周长就可以+1
     * 同时需要记录访问状态，使用原空间即可，将值标记为666
     */
    public int islandPerimeterWithDFS(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    // 找到了陆地，进入dfs搜索
                    return dfs(row, col, grid);
                }
            }
        }
        return 0;
    }

    /**
     * 执行用时：
     * 10 ms
     * , 在所有 Java 提交中击败了
     * 7.98%
     * 的用户
     * 内存消耗：
     * 42.2 MB
     * , 在所有 Java 提交中击败了
     * 42.49%
     * 的用户
     * 通过测试用例：
     * 5833 / 5833
     */
    private int dfs(int x, int y, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || grid[x][y] == 0) {
            // 从陆地来到边界，边长+1
            // 从陆地来到水区，边长+1
            return 1;
        }
        if (grid[x][y] == 666) {
            // 已访问节点
            return 0;
        }
        // 标记当前点已被访问
        grid[x][y] = 666;
        int perimeter = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            perimeter += dfs(x + direction[0], y + direction[1], grid);
        }
        return perimeter;
    }
}
