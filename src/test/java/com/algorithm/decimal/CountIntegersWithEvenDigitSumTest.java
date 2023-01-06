package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountIntegersWithEvenDigitSumTest {

    @Test
    public void countEven() {
        CountIntegersWithEvenDigitSum service = new CountIntegersWithEvenDigitSum();
        assertEquals(2, service.countEven(4));
        assertEquals(14, service.countEven(30));
    }
}