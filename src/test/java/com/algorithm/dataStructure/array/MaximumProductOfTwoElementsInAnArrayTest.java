package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumProductOfTwoElementsInAnArrayTest {

    @Test
    public void maxProduct() {
        MaximumProductOfTwoElementsInAnArray service = new MaximumProductOfTwoElementsInAnArray();
        assertEquals(12, service.maxProduct(new int[]{3, 4, 5, 2}));
        assertEquals(16, service.maxProduct(new int[]{1, 5, 4, 5}));
        assertEquals(12, service.maxProduct(new int[]{3, 7}));
        assertEquals(12, service.maxProduct2(new int[]{3, 4, 5, 2}));
        assertEquals(16, service.maxProduct2(new int[]{1, 5, 4, 5}));
        assertEquals(12, service.maxProduct2(new int[]{3, 7}));
    }
}