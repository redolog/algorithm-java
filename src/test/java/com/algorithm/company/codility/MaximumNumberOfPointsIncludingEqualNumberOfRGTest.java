package com.algorithm.company.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumNumberOfPointsIncludingEqualNumberOfRGTest {

    @Test
    public void maximumNumberOfPointsIncludingEqualNumberOfRG() {
        MaximumNumberOfPointsIncludingEqualNumberOfRG service = new MaximumNumberOfPointsIncludingEqualNumberOfRG();
        assertEquals(2, service.maximumNumberOfPointsIncludingEqualNumberOfRG(new int[]{4, 0, 2, -2}, new int[]{4, 1, 2, -3}, "RGRR"));
        assertEquals(4, service.maximumNumberOfPointsIncludingEqualNumberOfRG(new int[]{1, 1, -1, -1}, new int[]{1, -1, 1, -1}, "RGRG"));
        assertEquals(0, service.maximumNumberOfPointsIncludingEqualNumberOfRG(new int[]{1, 0, 0}, new int[]{0, 1, -1}, "GGR"));
        assertEquals(2, service.maximumNumberOfPointsIncludingEqualNumberOfRG(new int[]{5, -5, 5}, new int[]{1, -1, -3}, "GRG"));
        assertEquals(2, service.maximumNumberOfPointsIncludingEqualNumberOfRG(new int[]{3000, -3000, 4100, -4100, -3000}, new int[]{5000, -5000, 4100, -4100, 5000}, "RRGRG"));
    }
}