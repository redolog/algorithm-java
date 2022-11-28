package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumChangesToMakeAlternatingBinaryStringTest {

    @Test
    public void minOperations() {
        MinimumChangesToMakeAlternatingBinaryString service = new MinimumChangesToMakeAlternatingBinaryString();
        assertEquals(1, service.minOperations("0100"));
        assertEquals(0, service.minOperations("10"));
        assertEquals(2, service.minOperations("1111"));
    }
}