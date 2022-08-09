package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumValueToGetPositiveStepByStepSumTest {

    @Test
    public void minStartValue() {
        MinimumValueToGetPositiveStepByStepSum service = new MinimumValueToGetPositiveStepByStepSum();
        assertEquals(5, service.minStartValue(new int[]{-3, 2, -3, 4, 2}));
        assertEquals(5, service.minStartValue(new int[]{1, -2, -3}));
        assertEquals(1, service.minStartValue(new int[]{1, 2, 1}));
        assertEquals(1, service.minStartValue(new int[]{2, 3, 5, -5, -1}));
        assertEquals(2, service.minStartValue(new int[]{5, 4, -5, -5, 0}));
    }
}