package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountOddNumbersInAnIntervalRangeTest {

    @Test
    public void countOdds() {
        CountOddNumbersInAnIntervalRange service = new CountOddNumbersInAnIntervalRange();
        assertEquals(3, service.countOdds(3, 7));
        assertEquals(1, service.countOdds(8, 10));
    }
}