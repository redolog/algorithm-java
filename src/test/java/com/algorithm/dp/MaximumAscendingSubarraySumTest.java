package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumAscendingSubarraySumTest {

    @Test
    public void maxAscendingSum() {
        MaximumAscendingSubarraySum service = new MaximumAscendingSubarraySum();
        assertEquals(65, service.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        assertEquals(150, service.maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
        assertEquals(33, service.maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
        assertEquals(100, service.maxAscendingSum(new int[]{100, 10, 1}));
    }
}