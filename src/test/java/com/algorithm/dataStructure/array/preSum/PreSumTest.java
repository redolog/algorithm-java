package com.algorithm.dataStructure.array.preSum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PreSumTest {

    @Test
    public void testSumRange() {
        PreSum sumArr = new PreSum(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1, sumArr.sumRange(0, 2));
        assertEquals(-1, sumArr.sumRange(2, 5));
        assertEquals(-3, sumArr.sumRange(0, 5));
    }
}