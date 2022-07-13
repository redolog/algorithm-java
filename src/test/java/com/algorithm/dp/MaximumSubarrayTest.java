package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSubarrayTest {

    @Test
    public void maxSubArray() {
        MaximumSubarray.BF bf = new MaximumSubarray.BF();

        assertEquals(6, bf.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, bf.maxSubArray(new int[]{1}));
        assertEquals(23, bf.maxSubArray(new int[]{23}));

        MaximumSubarray.DP dp = new MaximumSubarray.DP();

        assertEquals(6, dp.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, dp.maxSubArray(new int[]{1}));
        assertEquals(23, dp.maxSubArray(new int[]{23}));
    }
}