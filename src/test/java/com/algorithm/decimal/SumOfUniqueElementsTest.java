package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfUniqueElementsTest {

    @Test
    public void sumOfUnique() {
        SumOfUniqueElements service = new SumOfUniqueElements();
        assertEquals(4, service.sumOfUnique(new int[]{1, 2, 3, 2}));
        assertEquals(0, service.sumOfUnique(new int[]{1, 1, 1, 1, 1}));
        assertEquals(15, service.sumOfUnique(new int[]{1, 2, 3, 4, 5}));
    }
}