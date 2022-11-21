package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SetMismatchTest {

    @Test
    public void findErrorNums() {
        SetMismatch service = new SetMismatch();
        assertArrayEquals(new int[]{2, 3}, service.findErrorNums(new int[]{1, 2, 2, 4}));
        assertArrayEquals(new int[]{1, 2}, service.findErrorNums(new int[]{1, 1}));
        assertArrayEquals(new int[]{1, 2}, service.findErrorNums(new int[]{1, 1}));
        assertArrayEquals(new int[]{2, 1}, service.findErrorNums(new int[]{3, 2, 2}));
        assertArrayEquals(new int[]{3, 2}, service.findErrorNums(new int[]{8, 7, 3, 5, 3, 6, 1, 4}));
    }
}