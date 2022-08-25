package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleNumberIITest {

    @Test
    public void singleNumber() {
        SingleNumberII service = new SingleNumberII();
        assertEquals(3, service.singleNumber(new int[]{2, 2, 3, 2}));
        assertEquals(99, service.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}