package com.algorithm.dataStructure.matrix;

/**
 * https://leetcode.cn/problems/zero-matrix-lcci/
 *
 * @author songhuilong  @date 2022/9/30
 */
public class ZeroMatrixLcci {

    static class RowCol0WithinArr {
        /**
         * 使用给定矩阵的首行首列空间来标记0值位置，对于首行首列进行特判，先标记首行首列的0值状态，再处理除首行首列的矩阵空间，最后根据首行首列0状态处理首行首列
         * 使用 row0 col0 标记首行首列是否有0值，两个boolean变量占用 O(1) 空间
         * 空间复杂度：O(1)
         */
        public int[][] setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean row0 = false, col0 = false;
            // 首列有零则记录
            for (int[] row : matrix) {
                if (row[0] == 0) {
                    col0 = true;
                    break;
                }
            }
            // 首行有零则记录
            for (int col = 0; col < n; col++) {
                if (matrix[0][col] == 0) {
                    row0 = true;
                    break;
                }
            }

            // 使用首行首列空间标记矩阵中除了首行首列之外空间的0值
            for (int row = 1; row < m; row++) {
                for (int col = 1; col < n; col++) {
                    if (matrix[row][col] == 0) {
                        matrix[0][col] = 0;
                        matrix[row][0] = 0;
                    }
                }
            }
            // 使用首行首列标记的状态进行矩阵归零，只要当前行、列有0，当前点位则为0
            for (int row = 1; row < m; row++) {
                for (int col = 1; col < n; col++) {
                    if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                        matrix[row][col] = 0;
                    }
                }
            }
            // 首行首列中如果因其他同行同列且有0的状态已归零，此时针对首行首列本身有0的数据进行归零
            if (row0) {
                for (int col = 0; col < n; col++) {
                    matrix[0][col] = 0;
                }
            }
            if (col0) {
                for (int[] row : matrix) {
                    row[0] = 0;
                }
            }
            return matrix;
        }
    }

    static class RowCol0AdditionalArr {
        /**
         * 使用额外的行、列数组来标记矩阵中0所在行、列
         * 空间复杂度：O(m+n)
         */
        public int[][] setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean[] row0Arr = new boolean[m], col0Arr = new boolean[n];

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (matrix[row][col] == 0) {
                        row0Arr[row] = true;
                        col0Arr[col] = true;
                    }
                }
            }

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (row0Arr[row] || col0Arr[col]) {
                        matrix[row][col] = 0;
                    }
                }
            }
            return matrix;
        }
    }
}
