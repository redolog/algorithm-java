package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemovingMinimumAndMaximumFromArrayTest {

    @Test
    public void minimumDeletions() {
        RemovingMinimumAndMaximumFromArray service = new RemovingMinimumAndMaximumFromArray();
        assertEquals(5, service.minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6}));
        assertEquals(3, service.minimumDeletions(new int[]{0, -4, 19, 1, 8, -2, -3, 5}));
        assertEquals(1, service.minimumDeletions(new int[]{101}));
        assertEquals(11, service.minimumDeletions(new int[]{-1, -53, 93, -42, 37, 94, 97, 82, 46, 42, -99, 56, -76, -66, -67, -13, 10, 66, 85, -28}));
    }
}