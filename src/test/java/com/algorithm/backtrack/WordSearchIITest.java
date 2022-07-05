package com.algorithm.backtrack;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class WordSearchIITest {

    @Test
    public void findWords() {
//        WordSearchII.BackTrack backTrack = new WordSearchII.BackTrack();
//        assertEquals(Collections.emptyList(),backTrack.findWords(new char[][]{{'a','b'},{'c','d'}},new String[]{"abcb"}));
//        assertEquals(Arrays.asList("eat","oath"),backTrack.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},new String[]{"oath","pea","eat","rain"}));

        WordSearchII.Trie trie = new WordSearchII.Trie();
//        assertEquals(Collections.emptyList(),trie.findWords(new char[][]{{'a','b'},{'c','d'}},new String[]{"abcb"}));
        assertEquals(Arrays.asList("eat", "oath"), trie.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));

    }
}