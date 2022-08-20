package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeNeededToRearrangeABinaryStringTest {

    @Test
    public void secondsToRemoveOccurrences() {
        TimeNeededToRearrangeABinaryString service = new TimeNeededToRearrangeABinaryString();
        assertEquals(4, service.secondsToRemoveOccurrences("0110101"));
        assertEquals(0, service.secondsToRemoveOccurrences("11100"));
    }
}