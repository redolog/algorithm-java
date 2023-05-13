package com.algorithm.dataStructure.array.hash;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestPositiveIntegerThatExistsWithItsNegativeTest {

    @Test
    public void findMaxK() {
        LargestPositiveIntegerThatExistsWithItsNegative service = new LargestPositiveIntegerThatExistsWithItsNegative();
        assertEquals(3, service.findMaxK(new int[]{-1, 2, -3, 3}));
        assertEquals(7, service.findMaxK(new int[]{-1, 10, 6, 7, -7, 1}));
        assertEquals(-1, service.findMaxK(new int[]{-10, 8, 6, 7, -2, -3}));

    }
}