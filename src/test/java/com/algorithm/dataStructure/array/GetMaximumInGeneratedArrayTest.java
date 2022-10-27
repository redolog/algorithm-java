package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetMaximumInGeneratedArrayTest {

    @Test
    public void getMaximumGenerated() {
        GetMaximumInGeneratedArray service = new GetMaximumInGeneratedArray();
        assertEquals(3, service.getMaximumGenerated(7));
        assertEquals(1, service.getMaximumGenerated(2));
        assertEquals(2, service.getMaximumGenerated(3));
        assertEquals(0, service.getMaximumGenerated(0));
    }
}