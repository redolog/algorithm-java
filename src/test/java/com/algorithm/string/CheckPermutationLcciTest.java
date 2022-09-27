package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckPermutationLcciTest {

    @Test
    public void checkPermutation() {
        CheckPermutationLcci.MapSolution mapSolution = new CheckPermutationLcci.MapSolution();
        assertTrue(mapSolution.checkPermutation("abc", "bca"));
        assertFalse(mapSolution.checkPermutation("abc", "bad"));
        CheckPermutationLcci.SortSolution sortSolution = new CheckPermutationLcci.SortSolution();
        assertTrue(sortSolution.checkPermutation("abc", "bca"));
        assertFalse(sortSolution.checkPermutation("abc", "bad"));
    }
}