package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckIfArrayIsSortedAndRotatedTest {

    @Test
    public void check() {
        CheckIfArrayIsSortedAndRotated service = new CheckIfArrayIsSortedAndRotated();
        assertTrue(service.check(new int[]{3, 4, 5, 1, 2}));
        assertTrue(service.check(new int[]{1, 2, 3}));
        assertTrue(service.check(new int[]{1, 1, 1}));
        assertTrue(service.check(new int[]{7, 9, 1, 1, 1, 3}));
        assertFalse(service.check(new int[]{2, 1, 3, 4}));
        assertFalse(service.check(new int[]{6, 4, 7, 1, 3}));
    }
}