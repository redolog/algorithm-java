package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestContinuousIncreasingSubsequenceTest {

    @Test
    public void findLengthOfLCIS() {
        LongestContinuousIncreasingSubsequence.NativeDP nativeDP = new LongestContinuousIncreasingSubsequence.NativeDP();
        assertEquals(3, nativeDP.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        assertEquals(1, nativeDP.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }
}