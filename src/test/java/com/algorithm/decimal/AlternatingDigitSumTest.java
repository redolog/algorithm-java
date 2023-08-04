package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlternatingDigitSumTest {

    @Test
    public void alternateDigitSum() {
        AlternatingDigitSum service = new AlternatingDigitSum();
        assertEquals(4, service.alternateDigitSum(521));
        assertEquals(1, service.alternateDigitSum(111));
        assertEquals(0, service.alternateDigitSum(886996));
    }
}