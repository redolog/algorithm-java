package com.algorithm.dataStructure.matrix;

/**
 * https://leetcode.cn/problems/find-the-width-of-columns-of-a-grid/
 *
 * @author songhuilong001  @date 2023/4/16
 */
public class FindTheWidthOfColumnsOfAGrid {

    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] ans = new int[n];
        for (int c = 0; c < n; c++) {
            int width = 1;
            for (int r = 0; r < m; r++) {
                width = Math.max(width, String.valueOf(grid[r][c]).length());
            }
            ans[c] = width;
        }
        return ans;
    }
}
