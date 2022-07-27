package com.algorithm.lookup.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumNumberOfDaysToMakeMBouquetsTest {

    @Test
    public void minDays() {
        MinimumNumberOfDaysToMakeMBouquets service = new MinimumNumberOfDaysToMakeMBouquets();
        int[] bloomDay1 = {1, 10, 3, 10, 2};
        assertEquals(3, service.minDays(bloomDay1, 3, 1));
        assertEquals(1, service.flowerNumberByDays(bloomDay1, 1, 1));
        assertEquals(2, service.flowerNumberByDays(bloomDay1, 2, 1));
        assertEquals(5, service.flowerNumberByDays(bloomDay1, 10, 1));

        assertEquals(-1, service.minDays(bloomDay1, 3, 2));
        assertEquals(0, service.flowerNumberByDays(bloomDay1, 1, 2));
        assertEquals(0, service.flowerNumberByDays(bloomDay1, 2, 2));
        assertEquals(2, service.flowerNumberByDays(bloomDay1, 10, 2));
        int[] bloomDay2 = {7, 7, 7, 7, 12, 7, 7};
        assertEquals(12, service.minDays(bloomDay2, 2, 3));
        int[] bloomDay3 = {1000000000, 1000000000};
        assertEquals(1000000000, service.minDays(bloomDay3, 1, 1));
    }
}