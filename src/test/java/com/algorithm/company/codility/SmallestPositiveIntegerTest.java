package com.algorithm.company.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmallestPositiveIntegerTest {

    @Test
    public void smallestPositiveInteger() {
        SmallestPositiveInteger service = new SmallestPositiveInteger();
        assertEquals(5, service.smallestPositiveInteger(new int[]{1, 3, 6, 4, 1, 2}));
        assertEquals(4, service.smallestPositiveInteger(new int[]{1, 2, 3}));
        assertEquals(1, service.smallestPositiveInteger(new int[]{-1, -3}));
    }
}