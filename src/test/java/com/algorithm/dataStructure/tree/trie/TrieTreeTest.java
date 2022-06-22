package com.algorithm.dataStructure.tree.trie;

import org.junit.Assert;
import org.junit.Test;

public class TrieTreeTest {

    @Test
    public void print() {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("apple");
        trieTree.insert("abandon");
        trieTree.insert("array");

        Assert.assertTrue(trieTree.find("apple"));
        Assert.assertFalse(trieTree.find("app"));

        trieTree.print();
    }
}