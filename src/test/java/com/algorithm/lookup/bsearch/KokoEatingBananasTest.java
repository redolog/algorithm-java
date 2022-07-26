package com.algorithm.lookup.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KokoEatingBananasTest {

    @Test
    public void minEatingSpeed() {
        KokoEatingBananas service = new KokoEatingBananas();
        assertEquals(4, service.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        assertEquals(30, service.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        assertEquals(23, service.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        assertEquals(3, service.minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }
}