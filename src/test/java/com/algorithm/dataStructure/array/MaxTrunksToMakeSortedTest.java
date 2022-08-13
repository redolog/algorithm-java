package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxTrunksToMakeSortedTest {

    @Test
    public void maxChunksToSorted() {
        MaxTrunksToMakeSorted service = new MaxTrunksToMakeSorted();
        assertEquals(1, service.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        assertEquals(4, service.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        assertEquals(2, service.maxChunksToSorted(new int[]{1, 2, 0, 3}));
        assertEquals(2, service.maxChunksToSorted(new int[]{2, 0, 1, 3}));
        assertEquals(1, service.maxChunksToSorted(new int[]{4, 2, 1, 3, 5, 0}));
        assertEquals(2, service.maxChunksToSorted(new int[]{0, 4, 5, 2, 1, 3}));
    }
}