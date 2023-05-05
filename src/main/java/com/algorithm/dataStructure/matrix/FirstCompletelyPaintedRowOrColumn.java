package com.algorithm.dataStructure.matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/first-completely-painted-row-or-column/">2661. 找出叠涂元素</a>
 *
 * @author songhuilong  @date 2023/5/5
 */
public class FirstCompletelyPaintedRowOrColumn {

    static class MapSolution {
        /**
         * 由于是逐个遍历，题目所求则是先涂满某行或者某列时，对应行列元素所在arr最小的下标
         * 思路：
         * 记录每个元素所在行列；
         * 记录每行每列涂的进度、状态；
         * 开始叠涂；
         * 当某行或者某列涂完时，返回当前下标；
         */
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int m = mat.length, n = mat[0].length;
            Map<Integer, int[]> num2Coordinate = new HashMap<>();
            // 每行未被涂完的数
            Map<Integer, Integer> row2Cnt = new HashMap<>();
            for (int r = 0; r < m; r++) {
                row2Cnt.put(r, n);
            }
            // 每列未被涂完的数
            Map<Integer, Integer> col2Cnt = new HashMap<>();
            for (int c = 0; c < n; c++) {
                col2Cnt.put(c, m);
            }
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    num2Coordinate.put(mat[r][c], new int[]{r, c});
                }
            }

            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                int[] coordinate = num2Coordinate.get(num);
                int r = coordinate[0], c = coordinate[1];
                int rowCnt = row2Cnt.get(r) - 1;
                row2Cnt.put(r, rowCnt);
                int colCnt = col2Cnt.get(c) - 1;
                col2Cnt.put(c, colCnt);
                if (rowCnt == 0 || colCnt == 0) {
                    return i;
                }
            }
            return -1;
        }
    }

}
