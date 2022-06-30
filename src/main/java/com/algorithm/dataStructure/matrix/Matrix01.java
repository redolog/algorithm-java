package com.algorithm.dataStructure.matrix;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * mat 中至少有一个 0
 * <p>
 * https://leetcode.cn/problems/01-matrix/
 *
 * @author dragonsong  @date 2022/6/30
 */
public class Matrix01 {

    /*
     * 执行用时：
     * 12 ms
     * , 在所有 Java 提交中击败了
     * 61.51%
     * 的用户
     * 内存消耗：
     * 43.1 MB
     * , 在所有 Java 提交中击败了
     * 92.57%
     * 的用户
     * 通过测试用例：
     * 50 / 50
     */

    /**
     * 图的多源BFS：我们从0点出发，碰到未访问的1时，mat[x][y]=前一个点的值+1
     * 1未访问时，可将值设置为 Integer.MIN
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int UNVISITED1 = Integer.MIN_VALUE;

        Queue<int[]> pointQ = new LinkedList<>();
        // 将未访问1的值设置好，同时将0点入队
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    pointQ.offer(new int[]{row, col});
                } else {
                    mat[row][col] = UNVISITED1;
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pointQ.isEmpty()) {
            int size = pointQ.size();
            for (int i = 0; i < size; i++) {
                int[] point = pointQ.poll();
                int x = point[0];
                int y = point[1];

                for (int[] direction : directions) {
                    int nextX = x + direction[0];
                    int nextY = y + direction[1];

                    // 下个点为未访问过的1
                    if (inArea(nextX, m) && inArea(nextY, n) && mat[nextX][nextY] == UNVISITED1) {
                        mat[nextX][nextY] = mat[x][y] + 1;
                        // 访问过的1入队
                        pointQ.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return mat;
    }

    private boolean inArea(int x, int m) {
        return x >= 0 && x < m;
    }

    /*
     * 执行用时：
     * 14 ms
     * , 在所有 Java 提交中击败了
     * 25.09%
     * 的用户
     * 内存消耗：
     * 44.3 MB
     * , 在所有 Java 提交中击败了
     * 51.82%
     * 的用户
     * 通过测试用例：
     * 50 / 50
     */

    /**
     * bfs另一种做法，先入队与0相邻的1，再对入队元素处理
     * <p>
     * ArrayDeque 相比 LinkedList 优势：无多余node对象的创建开销；数组存储是连续的，可以利用CPU缓存行加速访问。
     * 手写难免有bug，可结合情况多debug，IDE还是比人眼更细致。
     */
    public int[][] updateMatrixBFS2(int[][] mat) {
        // 这种思路下，无法使用原数组标记1的访问状态，因为从队列中先出队了与0相邻的1，如果标识为了1，那么离0更远的1之后的发散则无法触达已经访问过的1
        // 所以使用一个新的数组来维护结果
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> pointQ = new ArrayDeque<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // 先入队0相邻的1点
                if (mat[row][col] == 0) {
                    for (int[] direction : directions) {
                        int newX = row + direction[0];
                        int newY = col + direction[1];
                        if (inArea(newX, m) && inArea(newY, n) && mat[newX][newY] == 1 && res[newX][newY] == 0) {
                            pointQ.offer(new int[]{newX, newY});
                            // 相邻的1，距离最近0的距离就是1了
                            res[newX][newY] = 1;
                        }
                    }
                }
            }
        }

        // 后面针对1点处理
        while (!pointQ.isEmpty()) {
            // 出队1
            int[] point = pointQ.poll();
            int x = point[0];
            int y = point[1];
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                // 新发散的点还没被处理， res[newX][newY]==0
                if (inArea(newX, m) && inArea(newY, n) && mat[newX][newY] == 1 && res[newX][newY] == 0) {
                    // 入队新的1点，继续往深层遍历
                    pointQ.offer(new int[]{newX, newY});
                    // 当前1点的距离在原先1到0的距离上+1
                    res[newX][newY] = res[x][y] + 1;
                }
            }
        }
        return res;
    }
}
