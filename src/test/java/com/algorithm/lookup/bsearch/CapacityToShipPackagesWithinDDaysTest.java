package com.algorithm.lookup.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CapacityToShipPackagesWithinDDaysTest {

    @Test
    public void shipWithinDays() {
        CapacityToShipPackagesWithinDDays service = new CapacityToShipPackagesWithinDDays();
        assertEquals(15, service.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        assertEquals(6, service.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        assertEquals(3, service.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }
}