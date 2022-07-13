package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testLongestIncreasingSubsequence() {
        LongestIncreasingSubsequence.DP dp = new LongestIncreasingSubsequence.DP();
        assertEquals(4, dp.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(4, dp.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        assertEquals(1, dp.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

}