package com.algorithm.dataStructure.matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * 3242. 设计相邻元素求和服务
 * 给你一个 n x n 的二维数组 grid，它包含范围 [0, n2 - 1] 内的不重复元素。
 * <p>
 * 实现 neighborSum 类：
 * <p>
 * neighborSum(int [][]grid) 初始化对象。
 * int adjacentSum(int value) 返回在 grid 中与 value 相邻的元素之和，相邻指的是与 value 在上、左、右或下的元素。
 * int diagonalSum(int value) 返回在 grid 中与 value 对角线相邻的元素之和，对角线相邻指的是与 value 在左上、右上、左下或右下的元素。
 * <p>
 * https://leetcode.cn/problems/design-neighbor-sum-service/description/
 *
 * @author songhuilong  @date 2024/11/9
 */
public class DesignNeighborSumService {

    class NeighborSum {
        // 矩阵的长宽
        int n;
        // 矩阵指针
        int[][] grid;
        // 值>位置
        Map<Integer, int[]> val2Idx;

        public NeighborSum(int[][] grid) {
            this.grid = grid;
            n = grid[0].length;
            val2Idx = new HashMap<>();
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    val2Idx.put(grid[row][col], new int[]{row, col});
                }
            }
        }

        public int adjacentSum(int value) {
            int[] idx = val2Idx.get(value);
            int row = idx[0];
            int col = idx[1];
            return getValueFromGrid(row, col - 1)
                    + getValueFromGrid(row - 1, col)
                    + getValueFromGrid(row, col + 1)
                    + getValueFromGrid(row + 1, col)
                    ;
        }

        public int diagonalSum(int value) {
            int[] idx = val2Idx.get(value);
            int row = idx[0];
            int col = idx[1];
            return getValueFromGrid(row - 1, col - 1)
                    + getValueFromGrid(row + 1, col + 1)
                    + getValueFromGrid(row - 1, col + 1)
                    + getValueFromGrid(row + 1, col - 1)
                    ;
        }

        private int getValueFromGrid(int row, int col) {
            if (row < 0 || row >= n || col < 0 || col >= n) {
                // 越界，值相当于0
                return 0;
            }
            return grid[row][col];
        }
    }
}
