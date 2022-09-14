package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PowerOfTwoTest {

    @Test
    public void isPowerOfTwo() {
        PowerOfTwo service = new PowerOfTwo();
        for (int i = 2; i < 30; i++) {
            int pow = (int) Math.pow(2, i);
            assertTrue(service.isPowerOfTwo(pow));
            assertFalse(service.isPowerOfTwo(pow + 1));
            assertFalse(service.isPowerOfTwo(pow - 1));
            assertTrue(service.isPowerOfTwo2(pow));
            assertFalse(service.isPowerOfTwo2(pow + 1));
            assertFalse(service.isPowerOfTwo2(pow - 1));
            assertTrue(service.isPowerOfTwo3(pow));
            assertFalse(service.isPowerOfTwo3(pow + 1));
            assertFalse(service.isPowerOfTwo3(pow - 1));
        }
    }
}