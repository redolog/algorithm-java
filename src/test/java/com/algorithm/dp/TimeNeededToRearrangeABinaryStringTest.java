package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeNeededToRearrangeABinaryStringTest {

    @Test
    public void secondsToRemoveOccurrences() {
        TimeNeededToRearrangeABinaryString.BF bf = new TimeNeededToRearrangeABinaryString.BF();
        assertEquals(4, bf.secondsToRemoveOccurrences("0110101"));
        assertEquals(0, bf.secondsToRemoveOccurrences("11100"));
        TimeNeededToRearrangeABinaryString.DP dp = new TimeNeededToRearrangeABinaryString.DP();
        assertEquals(4, dp.secondsToRemoveOccurrences("0110101"));
        assertEquals(0, dp.secondsToRemoveOccurrences("11100"));
        assertEquals(4, dp.secondsToRemoveOccurrences("001011"));
        assertEquals(4, dp.secondsToRemoveOccurrences2("0110101"));
        assertEquals(0, dp.secondsToRemoveOccurrences2("11100"));
        assertEquals(4, dp.secondsToRemoveOccurrences3("0110101"));
        assertEquals(0, dp.secondsToRemoveOccurrences3("11100"));
        assertEquals(1, dp.secondsToRemoveOccurrences3("1101"));
    }
}