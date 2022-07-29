package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumNumberOfOperationsToConvertTimeTest {

    @Test
    public void convertTime() {
        MinimumNumberOfOperationsToConvertTime service = new MinimumNumberOfOperationsToConvertTime();
        assertEquals(3, service.convertTime("02:30", "04:35"));
        assertEquals(1, service.convertTime("11:00", "11:01"));
        assertEquals(7, service.convertTime("09:41", "10:34"));
        assertEquals(5, service.convertTime("13:55", "15:13"));
    }
}