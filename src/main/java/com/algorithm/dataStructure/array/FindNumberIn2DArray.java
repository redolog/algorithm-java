package com.algorithm.dataStructure.array;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 *
 * @author dragonsong  @date 2022/6/18
 */
public class FindNumberIn2DArray {

    /**
     * 执行用时：
     * 11 ms
     * , 在所有 Java 提交中击败了
     * 9.23%
     * 的用户
     * 内存消耗：
     * 47.2 MB
     * , 在所有 Java 提交中击败了
     * 49.24%
     * 的用户
     * 通过测试用例：
     * 129 / 129
     */
    public boolean searchMatrixBruteForce(int[][] matrix, int target) {
        int m = matrix[0].length;
        for (int[] ints : matrix) {
            for (int j = 0; j < m; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean searchMatrixWithBSearch(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int x = 0;
        int y = m - 1;

        while (x < n && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;

    }

    /**
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 93.78%
     * 的用户
     * 内存消耗：
     * 47.5 MB
     * , 在所有 Java 提交中击败了
     * 14.54%
     * 的用户
     * 通过测试用例：
     * 129 / 129
     */
    public boolean searchMatrixWithRowBSearch(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[n - 1][m - 1]) {
            return false;
        }

        int mid;
        for (int[] row : matrix) {
            int low = 0;
            int high = m - 1;
            while (low <= high) {
                mid = low + ((high - low) >> 1);
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] < target) {
                    low = mid + 1;
                } else if (row[mid] > target) {
                    high = mid - 1;
                }
            }
        }
        return false;

    }
}
