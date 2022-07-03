package com.algorithm.dataStructure.tree.trie;


/**
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 * <p>
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 *
 * @author dragonsong  @date 2022/7/3
 */
public class ImplementTriePrefixTree {

    /*
     * 执行用时：
     * 32 ms
     * , 在所有 Java 提交中击败了
     * 88.25%
     * 的用户
     * 内存消耗：
     * 50.7 MB
     * , 在所有 Java 提交中击败了
     * 27.82%
     * 的用户
     * 通过测试用例：
     * 16 / 16
     */
    static class Trie {

        /**
         * 当前节点字符表示
         */
        char c;
        /**
         * 下级词字符
         */
        Trie[] children;
        /**
         * 是否为结束点
         */
        boolean stop;

        public Trie() {
            // root
            children = new Trie[26];
        }

        private static boolean strEmpty(String str) {
            if (str == null || str.length() == 0) {
                return true;
            }
            return false;
        }

        public void insert(String word) {
            if (strEmpty(word)) {
                return;
            }
            char[] wordArr = word.toCharArray();
            Trie curr = this;
            for (int i = 0; i < wordArr.length; i++) {
                char c = wordArr[i];
                int charIdx = c - 'a';
                if (curr.children[charIdx] == null) {
                    Trie node = new Trie();
                    node.c = c;
                    curr.children[charIdx] = node;
                }
                if (i == wordArr.length - 1) {
                    curr.children[charIdx].stop = true;
                }
                curr = curr.children[charIdx];
            }
        }

        public boolean search(String word) {
            if (strEmpty(word)) {
                return false;
            }
            Trie lastNode = searchPrefixLastNode(word);
            return lastNode != null && lastNode.stop;
        }

        public boolean startsWith(String prefix) {
            if (strEmpty(prefix)) {
                return false;
            }
            Trie lastNode = searchPrefixLastNode(prefix);
            return lastNode != null;
        }

        private Trie searchPrefixLastNode(String prefix) {
            char[] wordArr = prefix.toCharArray();
            Trie curr = this;
            for (int i = 0; i < wordArr.length; i++) {
                char c = wordArr[i];
                int charIdx = c - 'a';
                if (curr == null || curr.children == null || curr.children[charIdx] == null) {
                    return null;
                }
                if (wordArr[i] != curr.children[charIdx].c) {
                    return null;
                }
                curr = curr.children[charIdx];
            }
            return curr;
        }

    }
}
