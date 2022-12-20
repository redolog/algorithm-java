package com.algorithm.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathUtilsTest {

    @Test
    public void mod() {
        assertEquals(2, MathUtils.mod(7, 5));
        assertEquals(1, MathUtils.mod(7, 6));
        assertEquals(Math.floorMod(-7, 4), MathUtils.mod(-7, 4));
    }

    @Test
    public void gcd() {
        assertEquals(4, MathUtils.gcd(12, 16));
        assertEquals(4, new MathUtils.GCDExtend().extendGCD(12, 16));
    }

    @Test
    public void lcm() {
        assertEquals(48, MathUtils.lcm(12, 16));
    }

    @Test
    public void testIsEvenOdd() {
        int n = 10000;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                Assert.assertTrue(MathUtils.isEven(i));
            } else {
                Assert.assertTrue(MathUtils.isOdd(i));
            }
        }
    }

    @Test
    public void isPrime() {
        assertTrue(MathUtils.isPrime(13));
        assertFalse(MathUtils.isPrime(12));
    }
}