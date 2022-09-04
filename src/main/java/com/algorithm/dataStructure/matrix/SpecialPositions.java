package com.algorithm.dataStructure.matrix;

/**
 * https://leetcode.cn/problems/special-positions-in-a-binary-matrix/
 *
 * @author DragonSong  @date 2022/9/4
 */
public class SpecialPositions {


    /**
     * 时间复杂度：遍历两次矩阵，O(m*n)
     * 空间复杂度：O(m+n)
     */
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // 记录每一行、每一列的1数量
        int[] rowCnt = new int[m], colCnt = new int[n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 1) {
                    rowCnt[r]++;
                    colCnt[c]++;
                }
            }
        }
        int ans = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 1 && rowCnt[r] == 1 && colCnt[c] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
