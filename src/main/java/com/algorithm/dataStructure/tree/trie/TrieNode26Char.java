package com.algorithm.dataStructure.tree.trie;

/**
 * 只处理 a-z 26个小写字符的特里树
 * 前缀树、字典树
 *
 * @author dragonsong  @date 2022/6/22
 */
public class TrieNode26Char {

    /**
     * 当前节点值
     */
    char val;
    /**
     * 子节点
     */
    TrieNode26Char[] children;
    /**
     * 是否为一个单词末位
     */
    boolean isEndingChar;

    public TrieNode26Char(char val) {
        this.val = val;
        this.children = new TrieNode26Char[26];
    }

}
