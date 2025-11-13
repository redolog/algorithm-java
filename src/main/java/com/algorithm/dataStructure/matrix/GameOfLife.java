package com.algorithm.dataStructure.matrix;

/**
 * https://leetcode.cn/problems/game-of-life/
 *
 * @author songhuilong  @date 2025/11/13
 */
public class GameOfLife {

    // 算法概述：
    // 使用一个额外的矩阵，记录每个细胞的下一个状态，空间复杂度O(m*n)
    // 逐个细胞遍历，判断当前细胞状态，规则如题目给定
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] state = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // 判断每个细胞周围的八个细胞状态，记录八个细胞中存活的数量
                int liveCnt = 0;
                for (int r1 = r - 1; r1 <= r + 1; r1++) {
                    for (int c1 = c - 1; c1 <= c + 1; c1++) {
                        if (r1 >= 0 && r1 < m && c1 >= 0 && c1 < n && (r1 != r || c1 != c) && board[r1][c1] == 1) {
                            liveCnt++;
                        }
                    }
                }
                // 区分当前细胞当前状态
                if (board[r][c] == 1) {
                    if (liveCnt < 2) {
                        state[r][c] = 0;
                    } else if (liveCnt >= 2 && liveCnt <= 3) {
                        state[r][c] = 1;
                    } else {
                        state[r][c] = 0;
                    }
                } else {
                    // 复活
                    if (liveCnt == 3) {
                        state[r][c] = 1;
                    } else {
                        state[r][c] = 0;
                    }
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = state[r][c];
            }
        }
    }

    static class OptimizeSpaceSolution {
        // 使用原矩阵空间，使用2表示由死到活， 使用3表示由活到死

        public void gameOfLife(int[][] board) {
            int m = board.length;
            int n = board[0].length;

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    // 判断每个细胞周围的八个细胞状态，记录八个细胞中存活的数量
                    int liveCnt = 0;
                    for (int r1 = r - 1; r1 <= r + 1; r1++) {
                        for (int c1 = c - 1; c1 <= c + 1; c1++) {
                            if (r1 >= 0 && r1 < m && c1 >= 0 && c1 < n && (r1 != r || c1 != c) && (board[r1][c1] == 1 || board[r1][c1] == 3)) {
                                liveCnt++;
                            }
                        }
                    }
                    // 区分当前细胞当前状态
                    if (board[r][c] == 1) {
                        if (liveCnt < 2) {
                            board[r][c] = 3;
                        } else if (liveCnt > 3) {
                            board[r][c] = 3;
                        }
                    } else {
                        // 复活
                        if (liveCnt == 3) {
                            board[r][c] = 2;
                        }
                    }
                }
            }

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (board[r][c] == 2) {
                        board[r][c] = 1;
                    }
                    if (board[r][c] == 3) {
                        board[r][c] = 0;
                    }
                }
            }
        }
    }
}
