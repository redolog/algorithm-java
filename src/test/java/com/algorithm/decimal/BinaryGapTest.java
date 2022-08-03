package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryGapTest {

    @Test
    public void binaryGap() {
        BinaryGap service = new BinaryGap();
        assertEquals(2, service.binaryGap(22));
        assertEquals(0, service.binaryGap(8));
        assertEquals(2, service.binaryGap(5));
    }
}