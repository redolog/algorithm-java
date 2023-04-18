package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindTheMaximumDivisibilityScoreTest {

    @Test
    public void maxDivScore() {
        FindTheMaximumDivisibilityScore.SortSolution sortSolution = new FindTheMaximumDivisibilityScore.SortSolution();
        assertEquals(3, sortSolution.maxDivScore(new int[]{4, 7, 9, 3, 9}, new int[]{5, 2, 3}));
        assertEquals(5, sortSolution.maxDivScore(new int[]{20, 14, 21, 10}, new int[]{5, 7, 5}));
        assertEquals(10, sortSolution.maxDivScore(new int[]{12}, new int[]{10, 16}));
        FindTheMaximumDivisibilityScore.IterationSolution iterationSolution = new FindTheMaximumDivisibilityScore.IterationSolution();
        assertEquals(3, iterationSolution.maxDivScore(new int[]{4, 7, 9, 3, 9}, new int[]{5, 2, 3}));
        assertEquals(5, iterationSolution.maxDivScore(new int[]{20, 14, 21, 10}, new int[]{5, 7, 5}));
        assertEquals(10, iterationSolution.maxDivScore(new int[]{12}, new int[]{10, 16}));
    }
}