package com.algorithm.dataStructure.matrix;

/**
 * https://leetcode.cn/problems/check-if-matrix-is-x-matrix/
 *
 * @author songhuilong001  @date 2022/11/13
 */
public class CheckIfMatrixIsXMatrix {

    /**
     * 逐个遍历，对角线为0 或 非对角线不为0 则不为xMatrix
     * 时间：O(n^2)
     * 空间：O(1)
     */
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int val = grid[r][c];
                if (r == c || r + c == n - 1) {
                    if (val == 0) {
                        return false;
                    }
                } else {
                    // 非对角线
                    if (val != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
