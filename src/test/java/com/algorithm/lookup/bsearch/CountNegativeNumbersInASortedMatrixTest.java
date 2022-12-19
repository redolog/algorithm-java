package com.algorithm.lookup.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountNegativeNumbersInASortedMatrixTest {

    @Test
    public void countNegatives() {
        CountNegativeNumbersInASortedMatrix service = new CountNegativeNumbersInASortedMatrix();
        assertEquals(8, service.countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
        assertEquals(0, service.countNegatives(new int[][]{{3, 2}, {1, 0}}));
        assertEquals(16, service.countNegatives(new int[][]{{3, -1, -3, -3, -3}, {2, -2, -3, -3, -3}, {1, -2, -3, -3, -3}, {0, -3, -3, -3, -3}}));
    }
}