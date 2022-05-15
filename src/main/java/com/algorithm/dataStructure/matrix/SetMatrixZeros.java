package com.algorithm.dataStructure.matrix;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * <p>
 * https://leetcode.cn/problems/set-matrix-zeroes/
 *
 * @author DragonSong  @date 2022/5/15
 */
public class SetMatrixZeros {

    /**
     * 取巧解：
     * 1. 使用0行0列记录行列0值情况，不额外申请空间
     * 2. 同时提前判断0行0列原本0值的情况，使用boolean标记，最后刷新0行0列
     *
     * 这个思路没看题解没想到
     */
    public void setZeroesZeroRowCol(int[][] matrix) {
        // todo 不是自己想的方案，就不写代码了
    }

    /**
     * 粗暴：存零所在位置
     */
    public static int[][] setZeroesBruteForce(int[][] matrix) {
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroColumns = new boolean[matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    zeroRows[row] = true;
                    zeroColumns[column] = true;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (zeroRows[row] || zeroColumns[column]) {
                    matrix[row][column] = 0;
                }
            }
        }
        return matrix;
    }
}
