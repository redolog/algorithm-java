package com.algorithm.dataStructure.array.subSequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestHarmoniousSubsequenceTest {

    @Test
    public void findLHS() {
        LongestHarmoniousSubsequence service = new LongestHarmoniousSubsequence();
        assertEquals(5, service.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        assertEquals(2, service.findLHS(new int[]{1, 2, 3, 4}));
        assertEquals(0, service.findLHS(new int[]{1, 1, 1, 1}));
    }
}