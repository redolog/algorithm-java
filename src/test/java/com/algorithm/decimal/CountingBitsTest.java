package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CountingBitsTest {

    @Test
    public void countBits() {
        CountingBits.CountByBit service = new CountingBits.CountByBit();
        assertArrayEquals(new int[]{0, 1, 1}, service.countBits(2));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, service.countBits(5));
    }
}