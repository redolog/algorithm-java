package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotatedDigitsTest {

    @Test
    public void rotatedDigits() {
        RotatedDigits service = new RotatedDigits();
        assertEquals(4, service.rotatedDigits(10));
    }
}