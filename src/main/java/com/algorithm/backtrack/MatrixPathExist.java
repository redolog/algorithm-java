package com.algorithm.backtrack;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * <p>
 * https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 * @author dragonsong  @date 2022/7/3
 */
public class MatrixPathExist {

    /*
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 22.87%
     * 的用户
     * 内存消耗：
     * 43.4 MB
     * , 在所有 Java 提交中击败了
     * 41.76%
     * 的用户
     * 通过测试用例：
     * 87 / 87
     */

    // 矩阵
    char[][] board;
    // 单词
    String word;
    // 四个方向
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    // 状态标记：单元格是否被访问过
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];

        // 从每个位置开始！
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                // 如果某个字符开头 dfs 搜索成功，就直接返回
                if (dfs(row, col, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * @param row 当前遍历行
     * @param col 当前遍历列
     * @param i   匹配成功的字符长
     */
    private boolean dfs(int row, int col, int i) {
        int m = board.length;
        int n = board[0].length;

        if (i == word.length()) {
            return true;
        }
        if (outArea(row, m) || outArea(col, n) || board[row][col] != word.charAt(i) || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        i++;
        for (int[] direction : directions) {
            int newX = row + direction[0];
            int newY = col + direction[1];
            if (dfs(newX, newY, i)) {
                return true;
            }
        }
        // 状态回撤
        i--;
        visited[row][col] = false;

        return false;
    }

    private boolean inArea(int x, int m) {
        return x >= 0 && x < m;
    }

    private boolean outArea(int x, int m) {
        return !inArea(x, m);
    }
}
