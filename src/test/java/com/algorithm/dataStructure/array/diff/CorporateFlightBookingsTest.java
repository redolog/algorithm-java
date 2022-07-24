package com.algorithm.dataStructure.array.diff;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CorporateFlightBookingsTest {

    @Test
    public void testCorporateFlightBookings() {
        CorporateFlightBookings.DiffArr diffArr = new CorporateFlightBookings.DiffArr();
        assertArrayEquals(new int[]{10, 55, 45, 25, 25}, diffArr.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5));
        assertArrayEquals(new int[]{10, 25}, diffArr.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2));
    }

}