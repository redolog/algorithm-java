package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordPatternTest {

    @Test
    public void wordPattern() {
        WordPattern service = new WordPattern();
        assertTrue(service.wordPattern("abba", "dog cat cat dog"));
        assertFalse(service.wordPattern("abba", "dog cat cat fish"));
        assertFalse(service.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(service.wordPattern("abba", "dog dog dog dog"));
        assertFalse(service.wordPattern("aba", "cat cat cat dog"));
        WordPattern.ExtractMatch extractMatch = new WordPattern.ExtractMatch();
        assertTrue(extractMatch.wordPattern("abba", "dog cat cat dog"));
        assertFalse(extractMatch.wordPattern("abba", "dog cat cat fish"));
        assertFalse(extractMatch.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(extractMatch.wordPattern("abba", "dog dog dog dog"));
        assertFalse(extractMatch.wordPattern("aba", "cat cat cat dog"));
        WordPattern.TwoMap twoMap = new WordPattern.TwoMap();
        assertTrue(twoMap.wordPattern("abba", "dog cat cat dog"));
        assertFalse(twoMap.wordPattern("abba", "dog cat cat fish"));
        assertFalse(twoMap.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(twoMap.wordPattern("abba", "dog dog dog dog"));
        assertFalse(twoMap.wordPattern("aba", "cat cat cat dog"));
        WordPattern.BigMapPutPrevIdx bigMapPutPrevIdx = new WordPattern.BigMapPutPrevIdx();
        assertTrue(bigMapPutPrevIdx.wordPattern("abba", "dog cat cat dog"));
        assertFalse(bigMapPutPrevIdx.wordPattern("abba", "dog cat cat fish"));
        assertFalse(bigMapPutPrevIdx.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(bigMapPutPrevIdx.wordPattern("abba", "dog dog dog dog"));
        assertFalse(bigMapPutPrevIdx.wordPattern("aba", "cat cat cat dog"));
    }
}