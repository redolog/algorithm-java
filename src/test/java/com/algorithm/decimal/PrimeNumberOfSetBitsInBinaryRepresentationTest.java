package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeNumberOfSetBitsInBinaryRepresentationTest {

    @Test
    public void countPrimeSetBits() {
        PrimeNumberOfSetBitsInBinaryRepresentation service = new PrimeNumberOfSetBitsInBinaryRepresentation();
        assertEquals(4, service.countPrimeSetBits(6, 10));
        assertEquals(5, service.countPrimeSetBits(10, 15));
    }
}