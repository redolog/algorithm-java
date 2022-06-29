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
     * <p>
     * 一个核心的点在于 0,0 位置，如果不提前判断，无法得知是否为后续首行首列的某个值将其置为0的
     * 0,0 位置 ==0：首行首列在标记完之后都得=0
     * 0,0 位置 !=0：不动
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 42.8 MB
     * , 在所有 Java 提交中击败了
     * 67.48%
     * 的用户
     * 通过测试用例：
     * 164 / 164
     */
    public int[][] setZeroesZeroRowCol(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 使用第一列记录该行是否需要置为0，本身某行出现了0值时，matrix[row][0]就应该==0
        // 一行一列是否有0
        boolean row0Zero = false;
        boolean col0Zero = false;
        for (int row = 0; row < m; row++) {
            if (matrix[row][0] == 0) {
                col0Zero = true;
                break;
            }
        }
        for (int col = 0; col < n; col++) {
            if (matrix[0][col] == 0) {
                row0Zero = true;
                break;
            }
        }

        // 判断 是否有0
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        // 将 第二行第二列开始 置0
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        // 处理第一行第一列
        if (col0Zero) {
            for (int row = 0; row < m; row++) {
                matrix[row][0] = 0;
            }
        }
        if (row0Zero) {
            for (int col = 0; col < n; col++) {
                matrix[0][col] = 0;
            }
        }
        return matrix;
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
