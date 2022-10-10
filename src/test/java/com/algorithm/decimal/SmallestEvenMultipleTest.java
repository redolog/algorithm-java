package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmallestEvenMultipleTest {

    @Test
    public void smallestEvenMultiple() {
        SmallestEvenMultiple service = new SmallestEvenMultiple();
        assertEquals(10, service.smallestEvenMultiple(5));
        assertEquals(6, service.smallestEvenMultiple(6));
        assertEquals(10, service.smallestEvenMultiple2(5));
        assertEquals(6, service.smallestEvenMultiple2(6));
    }
}