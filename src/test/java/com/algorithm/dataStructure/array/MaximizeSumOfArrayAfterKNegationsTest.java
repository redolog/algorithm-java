package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximizeSumOfArrayAfterKNegationsTest {

    @Test
    public void largestSumAfterKNegations() {
        MaximizeSumOfArrayAfterKNegations service = new MaximizeSumOfArrayAfterKNegations();
        assertEquals(5, service.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        assertEquals(6, service.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        assertEquals(13, service.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
        assertEquals(32, service.largestSumAfterKNegations(new int[]{-2, 9, 9, 8, 4}, 5));
        assertEquals(11, service.largestSumAfterKNegations(new int[]{-2, 5, 0, 2, -2}, 3));
        assertEquals(19, service.largestSumAfterKNegations(new int[]{-4, -6, 9, -2, 2}, 4));
    }
}