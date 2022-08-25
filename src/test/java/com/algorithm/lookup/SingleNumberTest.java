package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleNumberTest {

    @Test
    public void testSingleNumber() {
        SingleNumber service = new SingleNumber();
        assertEquals(1, service.singleNumberXor(new int[]{2, 2, 1}));
        assertEquals(4, service.singleNumberXor(new int[]{4, 1, 2, 1, 2}));
        assertEquals(1, service.singleNumberWithSet(new int[]{2, 2, 1}));
        assertEquals(4, service.singleNumberWithSet(new int[]{4, 1, 2, 1, 2}));
        assertEquals(1, service.singleNumberWithSetSum(new int[]{2, 2, 1}));
        assertEquals(4, service.singleNumberWithSetSum(new int[]{4, 1, 2, 1, 2}));
    }
}