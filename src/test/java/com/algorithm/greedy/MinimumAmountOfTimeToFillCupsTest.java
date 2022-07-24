package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumAmountOfTimeToFillCupsTest {

    @Test
    public void testFillCups() {
        MinimumAmountOfTimeToFillCups service = new MinimumAmountOfTimeToFillCups();
        assertEquals(4, service.fillCups(new int[]{1, 4, 2}));
        assertEquals(7, service.fillCups(new int[]{5, 4, 4}));
        assertEquals(5, service.fillCups(new int[]{5, 0, 0}));
    }
}