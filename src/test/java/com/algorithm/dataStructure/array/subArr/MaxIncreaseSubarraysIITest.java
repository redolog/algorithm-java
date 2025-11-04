package com.algorithm.dataStructure.array.subArr;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MaxIncreaseSubarraysIITest {

    @Test
    public void maxIncreasingSubarrays() {
        MaxIncreaseSubarraysII service = new MaxIncreaseSubarraysII();
        assertEquals(3, service.maxIncreasingSubarrays(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)));
        assertEquals(2, service.maxIncreasingSubarrays(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)));
    }
}