package com.algorithm.dataStructure.array.diff;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountVowelStringsInRangesTest {

    @Test
    public void test() {
        CountVowelStringsInRanges.BFSolution bfSolution = new CountVowelStringsInRanges.BFSolution();
        assertArrayEquals(new int[]{2, 3, 0}, bfSolution.vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}}));
        assertArrayEquals(new int[]{3, 2, 1}, bfSolution.vowelStrings(new String[]{"a", "e", "i"}, new int[][]{{0, 2}, {0, 1}, {2, 2}}));
        CountVowelStringsInRanges.DiffArraySolution diffArraySolution = new CountVowelStringsInRanges.DiffArraySolution();
        assertArrayEquals(new int[]{2, 3, 0}, diffArraySolution.vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}}));
        assertArrayEquals(new int[]{3, 2, 1}, diffArraySolution.vowelStrings(new String[]{"a", "e", "i"}, new int[][]{{0, 2}, {0, 1}, {2, 2}}));
    }

}