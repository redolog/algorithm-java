package com.algorithm.dataStructure.matrix;

/**
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 * <p>
 * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 * <p>
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 * <p>
 * 给你一个表示图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像 。
 * <p>
 * 提示:
 * <p>
 * m == img.length
 * n == img[i].length
 * 1 <= m, n <= 200
 * 0 <= img[i][j] <= 255
 *
 * <a href="https://leetcode.cn/problems/image-smoother/">661. 图片平滑器</a>
 *
 * @author songhuilong  @date 2024/11/18
 */
public class ImageSmother {

    static class BFSolution {
        int m;
        int n;
        int[][] img;

        public int[][] imageSmoother(int[][] img) {
            m = img.length;
            n = img[0].length;
            this.img = img;

            int[][] ans = new int[m][n];
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    ans[row][col] = smooth(row, col);
                }
            }
            return ans;
        }

        private int smooth(int row, int col) {
            // 周围八个有效点的值和+本点的和 / 周围的有效个数+1
            int[][] roundPoints = {
                    {row - 1, col - 1}, {row - 1, col}, {row - 1, col + 1}
                    , {row, col - 1}, {row, col}, {row, col + 1}
                    , {row + 1, col - 1}, {row + 1, col}, {row + 1, col + 1}
            };
            int validSum = 0;
            int validCnt = 0;
            for (int[] point : roundPoints) {
                validSum += getValidValue(point[0], point[1]);
                validCnt += getValidCnt(point[0], point[1]);
            }
            return validSum / validCnt;
        }

        private int getValidCnt(int row, int col) {
            if (invalidPoint(row, col)) {
                return 0;
            }
            return 1;
        }

        private boolean invalidPoint(int row, int col) {
            return row < 0 || row >= m || col < 0 || col >= n;
        }

        private int getValidValue(int row, int col) {
            if (invalidPoint(row, col)) {
                return 0;
            }
            return img[row][col];
        }
    }

    static class PreSumSolution {
        public int[][] imageSmoother(int[][] img) {
            int m = img.length;
            int n = img[0].length;
            // preSum[r][c] 表示 (0,0)到(r,c)的所有单元格的和
            int[][] preSum = new int[m][n];
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (x == 0 && y == 0) {
                        preSum[x][y] = img[x][y];
                    } else {
                        // x,y的左上角点
                        int x1 = Math.max(x - 1, 0);
                        int y1 = Math.max(y - 1, 0);
//                     (0,2)
//                     (0,1)
                        preSum[x][y] = img[x][y] + preSum[x1][y] + preSum[x][y1] - preSum[x1][y1];
                    }
                }
            }

            int[][] ans = new int[m][n];
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    // x,y的左上角点
                    int x1 = Math.max(x - 1, 0);
                    int y1 = Math.max(y - 1, 0);
                    // x,y的右下角点
                    int x2 = Math.min(x + 1, m - 1);
                    int y2 = Math.min(y + 1, n - 1);
                    int sum = preSum[x2][y2] - preSum[x1][y1] - preSum[x1][y] + preSum[x][y1];
                    int cnt = (x2 - x1 + 1) * (y2 - y1 + 1);
                    ans[x][y] = sum / cnt;
                }
            }
            return ans;
        }
    }

}
