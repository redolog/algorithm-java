package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSwapTest {

    @Test
    public void maximumSwap() {
        MaximumSwap service = new MaximumSwap();
        assertEquals(7236, service.maximumSwap(2736));
        assertEquals(9973, service.maximumSwap(9973));
        assertEquals(98863, service.maximumSwap(98368));
        assertEquals(511, service.maximumSwap(115));
        assertEquals(90909011, service.maximumSwap(10909091));
    }
}