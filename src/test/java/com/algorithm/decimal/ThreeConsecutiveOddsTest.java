package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreeConsecutiveOddsTest {

    @Test
    public void threeConsecutiveOdds() {
        ThreeConsecutiveOdds service = new ThreeConsecutiveOdds();
        assertFalse(service.threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        assertTrue(service.threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }
}