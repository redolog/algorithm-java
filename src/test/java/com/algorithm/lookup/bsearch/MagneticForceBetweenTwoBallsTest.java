package com.algorithm.lookup.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagneticForceBetweenTwoBallsTest {

    @Test
    public void maxDistance() {
        MagneticForceBetweenTwoBalls service = new MagneticForceBetweenTwoBalls();
        assertEquals(3, service.maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        assertEquals(999999999, service.maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
        assertEquals(12, service.maxDistance(new int[]{94, 95, 37, 30, 67, 7, 5, 44, 26, 55, 42, 28, 97, 19, 100, 74, 13, 88, 18}, 7));
    }
}