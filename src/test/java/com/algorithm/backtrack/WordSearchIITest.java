package com.algorithm.backtrack;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class WordSearchIITest {

    @Test
    public void findWords() {
        WordSearchII.BackTrack backTrack = new WordSearchII.BackTrack();
        assertTrue(CollectionUtils.equals(Collections.emptyList(), backTrack.findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcb"})));
        assertTrue(CollectionUtils.equals(Arrays.asList("eat", "oath"), backTrack.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"})));

        WordSearchII.Trie trie = new WordSearchII.Trie();
        assertTrue(CollectionUtils.equals(Collections.emptyList(), trie.findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcb"})));
        assertTrue(CollectionUtils.equals(Arrays.asList("eat", "oath"), trie.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"})));

    }
}