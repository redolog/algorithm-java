package com.algorithm.dataStructure.matrix;

/**
 * https://leetcode.cn/problems/flipping-an-image/
 *
 * @author songhuilong  @date 2022/10/10
 */
public class FlippingAnImage {

    /**
     * 时间复杂度：O(m*n)
     */
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length, n = image[0].length;
        int[][] ans = new int[m][n];
        // 逐行遍历
        for (int row = 0; row < m; row++) {
            // 列倒序遍历
            for (int col = n - 1; col >= 0; col--) {
                ans[row][-(col - n) - 1] = image[row][col] == 1 ? 0 : 1;
            }
        }
        return ans;
    }
}
