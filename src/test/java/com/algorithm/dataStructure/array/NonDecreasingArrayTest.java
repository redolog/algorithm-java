package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NonDecreasingArrayTest {

    @Test
    public void checkPossibility() {
        NonDecreasingArray service = new NonDecreasingArray();
        assertTrue(service.checkPossibility(new int[]{4, 2, 3}));
        assertFalse(service.checkPossibility(new int[]{4, 2, 1}));
        assertFalse(service.checkPossibility(new int[]{3, 4, 2, 3}));
        assertTrue(service.checkPossibility(new int[]{1, 4, 1, 2}));
    }
}