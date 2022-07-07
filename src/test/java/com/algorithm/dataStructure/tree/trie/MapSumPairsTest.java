package com.algorithm.dataStructure.tree.trie;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapSumPairsTest {

    @Test
    public void insert() {
        MapSumPairs.Trie trie = new MapSumPairs.Trie();
        trie.insert("apple", 3);
        assertEquals(3, trie.sum("ap"));
        trie.insert("app", 2);
        trie.insert("apple", 2);
        assertEquals(4, trie.sum("ap"));
        assertEquals(4, trie.sum("app"));

        MapSumPairs.BF bf = new MapSumPairs.BF();
        bf.insert("apple", 3);
        assertEquals(3, bf.sum("ap"));
        bf.insert("app", 2);
        bf.insert("apple", 2);
        assertEquals(4, bf.sum("ap"));
        assertEquals(4, bf.sum("app"));
    }
}