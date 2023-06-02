package com.algorithm.dataStructure.array.preSum;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountVowelStringsInRangesTest {

    @Test
    public void test() {
        CountVowelStringsInRanges.BFSolution bfSolution = new CountVowelStringsInRanges.BFSolution();
        assertArrayEquals(new int[]{2, 3, 0}, bfSolution.vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}}));
        assertArrayEquals(new int[]{3, 2, 1}, bfSolution.vowelStrings(new String[]{"a", "e", "i"}, new int[][]{{0, 2}, {0, 1}, {2, 2}}));
        CountVowelStringsInRanges.PreSumSolution preSumSolution = new CountVowelStringsInRanges.PreSumSolution();
        assertArrayEquals(new int[]{2, 3, 0}, preSumSolution.vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}}));
        assertArrayEquals(new int[]{3, 2, 1}, preSumSolution.vowelStrings(new String[]{"a", "e", "i"}, new int[][]{{0, 2}, {0, 1}, {2, 2}}));
    }

}