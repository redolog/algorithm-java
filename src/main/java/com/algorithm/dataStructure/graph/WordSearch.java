package com.algorithm.dataStructure.graph;

import java.util.Arrays;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * https://leetcode.cn/problems/word-search/
 *
 * @author dragonsong  @date 2022/6/20
 */
public class WordSearch {

    /**
     * 执行用时：
     * 91 ms
     * , 在所有 Java 提交中击败了
     * 63.10%
     * 的用户
     * 内存消耗：
     * 39.7 MB
     * , 在所有 Java 提交中击败了
     * 39.69%
     * 的用户
     * 通过测试用例：
     * 83 / 83
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        // 标记board使用状态
        boolean[][] used = new boolean[m][n];
        for (boolean[] booleans : used) {
            Arrays.fill(booleans, false);
        }
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (dfs(board, used, word, 0, row, col, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] used, String word, int wordIdx, int row, int col, int m, int n) {
        if (word.length() == wordIdx) {
            return true;
        }
        if (row < 0 || row > m - 1 || col < 0 || col > n - 1 || used[row][col] || board[row][col] != word.charAt(wordIdx)) {
            return false;
        }

        used[row][col] = true;
        ++wordIdx;

        // @formatter:off
        if (dfs(board, used, word, wordIdx, row, col - 1, m, n)
                || dfs(board, used, word, wordIdx, row, col + 1, m, n)
                || dfs(board, used, word, wordIdx, row - 1, col, m, n)
                || dfs(board, used, word, wordIdx, row + 1, col, m, n)) {
            return true;
        }
        // @formatter:on

        used[row][col] = false;
        --wordIdx;
        return false;
    }
}
