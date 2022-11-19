package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindTheLargestAltitudeTest {

    @Test
    public void largestAltitude() {
        FindTheLargestAltitude service = new FindTheLargestAltitude();
        assertEquals(1, service.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        assertEquals(0, service.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }
}