package com.algorithm.backtrack;


import java.util.*;

/**
 * 212. 单词搜索 II
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * https://leetcode.cn/problems/word-search-ii/
 *
 * @author dragonsong  @date 2022/7/3
 */
public class WordSearchII {

    static class Trie {
        /**
         * 执行用时：
         * 237 ms
         * , 在所有 Java 提交中击败了
         * 66.35%
         * 的用户
         * 内存消耗：
         * 41.8 MB
         * , 在所有 Java 提交中击败了
         * 47.83%
         * 的用户
         * 通过测试用例：
         * 63 / 63
         */

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int wordsCnt;

        TrieNode root;

        public Trie() {
            root = new TrieNode();
            root.children = new HashMap<>();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.wholeWord = word;
        }

        public List<String> findWords(char[][] board, String[] words) {
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            List<String> ansList = new ArrayList<>();
            root = new TrieNode();
            wordsCnt = words.length;

            for (String word : words) {
                insert(word);
            }

            // 从每个点开始搜
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    char currChar = board[row][col];
                    if (!root.children.containsKey(currChar)) {
                        continue;
                    }
                    visited[row][col] = true;

                    dfs(board, m, n, visited, ansList, row, col, root.children.get(currChar));

                    visited[row][col] = false;
                }
            }
            return ansList;
        }

        private void dfs(char[][] board, int m, int n, boolean[][] visited, List<String> ansList, int row, int col, TrieNode currNode) {
            if (currNode.wholeWord != null && !currNode.wholeWord.equals("")) {
                // 特里树上搜到了一个完整单词
                ansList.add(currNode.wholeWord);
                currNode.wholeWord = null;
            }
            if (ansList.size() == wordsCnt) {
                return;
            }

            for (int[] direction : directions) {
                int newX = row + direction[0];
                int newY = col + direction[1];
                if (outArea(newX, m) || outArea(newY, n) || visited[newX][newY] || !currNode.children.containsKey(board[newX][newY])) {
                    continue;
                }
                visited[newX][newY] = true;
                dfs(board, m, n, visited, ansList, newX, newY, currNode.children.get(board[newX][newY]));
                visited[newX][newY] = false;
            }
        }

        private boolean inArea(int x, int m) {
            return x >= 0 && x < m;
        }

        private boolean outArea(int x, int m) {
            return !inArea(x, m);
        }

        class TrieNode {
            // 完整单词
            String wholeWord;
            // 当前节点字符 -》 下级
            Map<Character, TrieNode> children;

            public TrieNode() {
                children = new HashMap<>();
            }
        }
    }

    static class BackTrack {
        // 矩阵
        char[][] board;
        // 四个方向
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // 状态标记：单元格是否被访问过
        boolean[][] visited;
        // 答案
        List<String> ans;
        // 单词集合
        Set<String> wordSet;
        // words所有字符
        Set<String> wordCharSet;

        public List<String> findWords(char[][] board, String[] words) {
            this.board = board;
            this.visited = new boolean[board.length][board[0].length];
            this.ans = new ArrayList<>();
            this.wordSet = new HashSet<>();
            this.wordCharSet = new HashSet<>();
            wordSet.addAll(Arrays.asList(words));

            for (String word : words) {
                for (char c : word.toCharArray()) {
                    wordCharSet.add(String.valueOf(c));
                }
            }

            search(board);

            return ans;
        }

        private void search(char[][] board) {
            StringBuilder word = new StringBuilder();
            // 从每个位置开始！
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (!wordCharSet.contains(String.valueOf(board[row][col]))) {
                        continue;
                    }

                    visited[row][col] = true;
                    word.append(board[row][col]);
                    dfs(row, col, word);
                    visited[row][col] = false;
                    word.deleteCharAt(word.length() - 1);
                }
            }
        }

        private void dfs(int row, int col, StringBuilder word) {
            int m = board.length;
            int n = board[0].length;

            // 已经搜到了一个单词
            String wordStr = word.toString();
            if (wordSet.contains(wordStr)) {
                ans.add(wordStr);
                // 同时删掉wordSet中这个单词，因为之后的搜索不需要重复元素了
                wordSet.remove(wordStr);
            }

            for (int[] direction : directions) {
                int newX = row + direction[0];
                int newY = col + direction[1];
                if (outArea(newX, m) || outArea(newY, n) || visited[newX][newY]) {
                    continue;
                }
                visited[newX][newY] = true;
                word.append(board[newX][newY]);
                dfs(newX, newY, word);
                // 状态回撤
                visited[newX][newY] = false;
                word.deleteCharAt(word.length() - 1);
            }
        }

        private boolean inArea(int x, int m) {
            return x >= 0 && x < m;
        }

        private boolean outArea(int x, int m) {
            return !inArea(x, m);
        }
    }

}
