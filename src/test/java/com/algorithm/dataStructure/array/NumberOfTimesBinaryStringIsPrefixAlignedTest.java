package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfTimesBinaryStringIsPrefixAlignedTest {

    @Test
    public void numTimesAllBlue() {
        NumberOfTimesBinaryStringIsPrefixAligned service = new NumberOfTimesBinaryStringIsPrefixAligned();
        assertEquals(2, service.numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
        assertEquals(1, service.numTimesAllBlue(new int[]{4, 1, 2, 3}));
    }
}