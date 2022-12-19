package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumOperationsToMakeTheArrayIncreasingTest {

    @Test
    public void minOperations() {
        MinimumOperationsToMakeTheArrayIncreasing service = new MinimumOperationsToMakeTheArrayIncreasing();
        assertEquals(3, service.minOperations(new int[]{1, 1, 1}));
        assertEquals(14, service.minOperations(new int[]{1, 5, 2, 4, 1}));
        assertEquals(0, service.minOperations(new int[]{8}));
    }
}