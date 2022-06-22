package com.algorithm.dataStructure.tree.trie;

import java.util.Deque;
import java.util.LinkedList;

public class TrieTree {

    /**
     * 根节点不存储val
     */
    private final TrieNode26Char root = new TrieNode26Char('-');

    public void insert(String word) {
        insert(word.toCharArray());
    }

    public void insert(char[] word) {
        TrieNode26Char curr = root;
        for (int i = 0; i < word.length; i++) {
            int iIdx = word[i] - 'a';
            if (curr.children[iIdx] == null) {
                curr.children[iIdx] = new TrieNode26Char(word[i]);
            }
            curr = curr.children[iIdx];
        }
        curr.isEndingChar = true;
    }

    public boolean find(String word) {
        return find(word.toCharArray());
    }

    public boolean find(char[] word) {
        TrieNode26Char curr = root;
        for (char c : word) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isEndingChar;
    }

    public void print() {
        Deque<TrieNode26Char> queue = new LinkedList<>();
        queue.offerLast(root);

        int level = 0;
        while (!queue.isEmpty()) {
            ++level;
            int size = queue.size();
            System.out.print("第" + level + "层：");
            for (int i = 0; i < size; i++) {
                TrieNode26Char node = queue.pollFirst();
                if (node == null) {
                    continue;
                }
                System.out.print(node.val + "  ");
                if (node.children != null) {
                    for (TrieNode26Char child : node.children) {
                        queue.offerLast(child);
                    }
                }
            }
            System.out.println();
        }

    }

}
