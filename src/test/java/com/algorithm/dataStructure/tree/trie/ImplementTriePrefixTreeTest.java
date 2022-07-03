package com.algorithm.dataStructure.tree.trie;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ImplementTriePrefixTreeTest {

    @Test
    public void testImplementTriePrefixTree() {
        ImplementTriePrefixTree.Trie trie = new ImplementTriePrefixTree.Trie();

        trie.insert("a");
        assertTrue(trie.search("a"));
        assertTrue(trie.startsWith("a"));

        trie.search("a");

        trie.insert("apple");
        assertTrue(trie.search("apple"));   // 返回 True
        assertFalse(trie.search("app"));     // 返回 False
        assertTrue(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        assertTrue(trie.search("app"));     // 返回 True

    }

}