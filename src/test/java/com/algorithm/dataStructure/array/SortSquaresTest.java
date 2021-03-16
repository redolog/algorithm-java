package com.algorithm.dataStructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortSquaresTest {

    SortSquares service;

    @Before
    public void init() {
        service = new SortSquares();
    }

    @Test
    public void testSortedSquares() {
        Assert.assertArrayEquals(new int[]{0, 1, 9, 16, 100}, service.sortedSquares(new int[]{-4, -1, 0, 3, 10}));
        Assert.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, service.sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    }
}