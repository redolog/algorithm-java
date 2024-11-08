package com.algorithm.dataStructure.array.slidingWindow;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindThePowerOfKSizeSubArraysITest {

    @Test
    public void resultsArray() {
        FindThePowerOfKSizeSubArraysI service = new FindThePowerOfKSizeSubArraysI();
        assertArrayEquals(new int[]{3, 4, -1, -1, -1}, service.resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3));
        assertArrayEquals(new int[]{-1, -1}, service.resultsArray(new int[]{2, 2, 2, 2, 2}, 4));
        assertArrayEquals(new int[]{-1, 3, -1, 3, -1}, service.resultsArray(new int[]{3, 2, 3, 2, 3, 2}, 2));
    }
}