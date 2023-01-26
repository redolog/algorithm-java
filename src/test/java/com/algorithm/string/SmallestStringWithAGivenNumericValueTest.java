package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmallestStringWithAGivenNumericValueTest {

    @Test
    public void getSmallestString() {
        SmallestStringWithAGivenNumericValue service = new SmallestStringWithAGivenNumericValue();
        assertEquals("aay", service.getSmallestString(3, 27));
        assertEquals("aaszz", service.getSmallestString(5, 73));
    }
}