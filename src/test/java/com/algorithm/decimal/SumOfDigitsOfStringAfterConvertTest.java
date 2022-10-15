package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfDigitsOfStringAfterConvertTest {

    @Test
    public void getLucky() {
        SumOfDigitsOfStringAfterConvert service = new SumOfDigitsOfStringAfterConvert();
        assertEquals(36, service.getLucky("iiii", 1));
        assertEquals(6, service.getLucky("leetcode", 2));
        assertEquals(8, service.getLucky("zbax", 2));
    }
}