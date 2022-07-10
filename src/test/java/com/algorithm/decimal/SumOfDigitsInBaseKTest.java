package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfDigitsInBaseKTest {

    @Test
    public void sumBase() {
        SumOfDigitsInBaseK service = new SumOfDigitsInBaseK();
        assertEquals(1, service.sumBase(10, 10));
        assertEquals(9, service.sumBase(34, 6));
    }
}