package com.algorithm.dataStructure.matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/row-with-maximum-ones/">2643. 一最多的行</a>
 *
 * @author songhuilong  @date 2023/4/17
 */
public class RowWithMaximumOnes {

    static class OrderSolution {
        public int[] rowAndMaximumOnes(int[][] mat) {
            int m = mat.length, maxSum = 0, maxRow = 0;
            // 倒序遍历到第0行
            for (int r = m - 1; r >= 0; r--) {
                int rowSum = 0;
                for (int c = 0; c < mat[r].length; c++) {
                    rowSum += mat[r][c];
                }
                if (rowSum >= maxSum) {
                    maxSum = rowSum;
                    maxRow = r;
                }
            }
            return new int[]{maxRow, maxSum};
        }
    }

    static class MapSolution {
        public int[] rowAndMaximumOnes(int[][] mat) {
            int m = mat.length, n = mat[0].length, maxOneCnt = 0;
            Map<Integer, Integer> row2OneCnt = new HashMap<>();
            for (int r = 0; r < m; r++) {
                for (int num : mat[r]) {
                    if (num == 1) {
                        int cnt = row2OneCnt.getOrDefault(r, 0) + 1;
                        row2OneCnt.put(r, cnt);
                        maxOneCnt = Math.max(maxOneCnt, cnt);
                    }
                }
            }

            int[] ans = new int[]{0, 0};
            if (maxOneCnt == 0) {
                return ans;
            }
            for (Map.Entry<Integer, Integer> entry : row2OneCnt.entrySet()) {
                int row = entry.getKey(), oneCnt = entry.getValue();
                // 当前行计数为 maxOneCnt 最多1的计数
                // a. 行下标比答案中的下标靠前
                // b. 当前答案数组还未处理过
                if (oneCnt == maxOneCnt && (row < ans[0] || clean(ans))) {
                    ans[0] = row;
                    ans[1] = oneCnt;
                }
            }
            return ans;
        }

        private boolean clean(int[] arr) {
            return arr[0] == 0 && arr[1] == 0;
        }
    }

}
