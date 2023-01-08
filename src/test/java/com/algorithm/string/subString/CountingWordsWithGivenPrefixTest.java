package com.algorithm.string.subString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountingWordsWithGivenPrefixTest {

    @Test
    public void prefixCount() {
        CountingWordsWithGivenPrefix.TwoPointerSolution twoPointerSolution = new CountingWordsWithGivenPrefix.TwoPointerSolution();
        assertEquals(2, twoPointerSolution.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
        assertEquals(0, twoPointerSolution.prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code"));
        CountingWordsWithGivenPrefix.StreamSolution streamSolution = new CountingWordsWithGivenPrefix.StreamSolution();
        assertEquals(2, streamSolution.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
        assertEquals(0, streamSolution.prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code"));
        CountingWordsWithGivenPrefix.TrieSolution trieSolution = new CountingWordsWithGivenPrefix.TrieSolution();
        assertEquals(2, trieSolution.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
        assertEquals(0, trieSolution.prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code"));
    }
}