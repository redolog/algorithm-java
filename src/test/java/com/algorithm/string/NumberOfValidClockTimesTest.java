package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfValidClockTimesTest {

    @Test
    public void countTime() {
        NumberOfValidClockTimes service = new NumberOfValidClockTimes();
        assertEquals(2, service.countTime("?5:00"));
        assertEquals(100, service.countTime("0?:0?"));
        assertEquals(1440, service.countTime("??:??"));
        assertEquals(3, service.countTime("?2:16"));
        assertEquals(240, service.countTime("2?:??"));
        assertEquals(1, service.countTime("21:08"));
    }
}