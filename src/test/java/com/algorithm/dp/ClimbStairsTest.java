package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClimbStairsTest {

    @Test
    public void climbStairs() {
        ClimbStairs.DP dp = new ClimbStairs.DP();
        assertEquals(2, dp.climbStairs(2));
        assertEquals(3, dp.climbStairs(3));
    }
}