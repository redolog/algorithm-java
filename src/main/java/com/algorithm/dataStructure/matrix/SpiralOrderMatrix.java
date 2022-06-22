package com.algorithm.dataStructure.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * https://leetcode.cn/problems/spiral-matrix/
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 *
 * @author dragonsong  @date 2022/6/21
 */
public class SpiralOrderMatrix {

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.8 MB
     * , 在所有 Java 提交中击败了
     * 6.81%
     * 的用户
     * 通过测试用例：
     * 23 / 23
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ansList = new ArrayList<>(m * n);
        int leftMost = 0, rightMost = n - 1, upMost = 1, downMost = m - 1;
        int row = 0, col = 0;

        ansList.add(matrix[0][0]);

        while (true) {
            // 向右
            ++col;
            while (col <= rightMost) {
                ansList.add(matrix[row][col++]);
            }
            --rightMost;
            --col;
            if (ansList.size() == m * n) break;
            // 向下
            ++row;
            while (row <= downMost) {
                ansList.add(matrix[row++][col]);
            }
            --downMost;
            --row;
            if (ansList.size() == m * n) break;
            // 向左
            --col;
            while (col >= leftMost) {
                ansList.add(matrix[row][col--]);
            }
            ++leftMost;
            ++col;
            if (ansList.size() == m * n) break;
            // 向上
            --row;
            while (row >= upMost) {
                ansList.add(matrix[row--][col]);
            }
            ++upMost;
            ++row;
            if (ansList.size() == m * n) break;
        }

        return ansList;
    }

}
