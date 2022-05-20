package com.algorithm.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}