package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestNumberAfterDigitSwapsByParityTest {

    @Test
    public void largestInteger() {
        LargestNumberAfterDigitSwapsByParity service = new LargestNumberAfterDigitSwapsByParity();
        assertEquals(3412, service.largestInteger(1234));
        assertEquals(87655, service.largestInteger(65875));
    }
}