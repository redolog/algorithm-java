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
    }
}