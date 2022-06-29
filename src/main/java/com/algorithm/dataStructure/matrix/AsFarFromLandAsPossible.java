package com.algorithm.dataStructure.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. 地图分析
 * 你现在手里有一份大小为 n x n 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地。
 * <p>
 * 请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的，并返回该距离。如果网格上只有陆地或者海洋，请返回 -1。
 * <p>
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] 不是 0 就是 1
 * <p>
 * https://leetcode.cn/problems/as-far-from-land-as-possible/
 *
 * @author dragonsong  @date 2022/6/29
 */
public class AsFarFromLandAsPossible {

    /**
     * 执行用时：
     * 12 ms
     * , 在所有 Java 提交中击败了
     * 87.45%
     * 的用户
     * 内存消耗：
     * 43 MB
     * , 在所有 Java 提交中击败了
     * 10.63%
     * 的用户
     * 通过测试用例：
     * 37 / 37
     */
    public int maxDistance(int[][] grid) {
        // n*n 的矩阵
        int n = grid.length;

        Queue<int[]> pointQ = new LinkedList<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // 入队所有陆地节点
                if (grid[row][col] == 1) {
                    pointQ.offer(new int[]{row, col});
                }
            }
        }
        // 全是海洋或者陆地
        if (pointQ.size() == 0 || pointQ.size() == n * n) {
            return -1;
        }
        int[][] directions = {
                // 向右，x+1
                {1, 0},
                // 向左，x-1
                {-1, 0},
                // 向上，y-1
                {0, -1},
                // 向下，y+1
                {0, 1},};
        // bfs 走遍全网格
        int[] point = new int[0];
        while (!pointQ.isEmpty()) {
            int size = pointQ.size();
            // 每一层我们同步走完，再走下一层，计算距离可以考虑在层的维度维护一个int，更加直观
            for (int level = 0; level < size; level++) {
                point = pointQ.poll();
                for (int i = 0; i < directions.length; i++) {
                    int[] direction = directions[i];
                    int xMove = direction[0];
                    int yMove = direction[1];

                    // 越界检查保证了不会出现NPE
                    int x = point[0] + xMove;
                    int y = point[1] + yMove;
                    // 下标不能越界
                    if (x < 0 || x > n - 1 || y < 0 || y > n - 1
                            // 0表示海洋，每次访问我们都将海洋点的值更新为距离
                            || grid[x][y] != 0) {
                        continue;
                    }
                    // 使用原矩阵，记录点挪动后的距离，因为每次我们只挪动一个单位，所以+1
                    grid[x][y] = grid[point[0]][point[1]] + 1;
                    pointQ.offer(new int[]{x, y});
                }
            }
        }
        // 我们最开始从1陆地出发，所以计算距离需要减去这个存量1
        return grid[point[0]][point[1]] - 1;
    }
}
