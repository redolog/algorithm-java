package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GiftMaxValueTest {

    @Test
    public void maxValue() {
        GiftMaxValue dp = new GiftMaxValue();
        assertEquals(12, dp.maxValue(new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
    }
}