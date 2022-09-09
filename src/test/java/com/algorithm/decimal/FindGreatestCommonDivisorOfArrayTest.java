package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindGreatestCommonDivisorOfArrayTest {

    @Test
    public void findGCD() {
        FindGreatestCommonDivisorOfArray service = new FindGreatestCommonDivisorOfArray();
        assertEquals(2, service.findGCD(new int[]{2, 5, 6, 9, 10}));
        assertEquals(1, service.findGCD(new int[]{7, 5, 6, 8, 3}));
        assertEquals(3, service.findGCD(new int[]{3, 3}));
    }
}