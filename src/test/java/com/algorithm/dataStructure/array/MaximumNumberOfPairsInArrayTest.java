package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MaximumNumberOfPairsInArrayTest {

    @Test
    public void numberOfPairs() {
        MaximumNumberOfPairsInArray service = new MaximumNumberOfPairsInArray();
        assertArrayEquals(new int[]{3, 1}, service.numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2}));
        assertArrayEquals(new int[]{1, 0}, service.numberOfPairs(new int[]{1, 1}));
        assertArrayEquals(new int[]{0, 1}, service.numberOfPairs(new int[]{0}));
    }
}