package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LatestTimeByReplacingHiddenDigitsTest {

    @Test
    public void maximumTime() {
        LatestTimeByReplacingHiddenDigits service = new LatestTimeByReplacingHiddenDigits();
        assertEquals("23:50", service.maximumTime("2?:?0"));
        assertEquals("09:39", service.maximumTime("0?:3?"));
        assertEquals("19:22", service.maximumTime("1?:22"));
    }
}