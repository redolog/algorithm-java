package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TopKFrequentElementsTest {

    @Test
    public void topKFrequent() {
        TopKFrequentElements.MinHeap minHeap = new TopKFrequentElements.MinHeap();
        assertArrayEquals(new int[]{2, 1}, minHeap.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[]{1}, minHeap.topKFrequent(new int[]{1}, 1));
        TopKFrequentElements.QuickSort quickSort = new TopKFrequentElements.QuickSort();
        assertArrayEquals(new int[]{1, 2}, quickSort.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[]{1}, quickSort.topKFrequent(new int[]{1}, 1));
        assertArrayEquals(new int[]{1, 2}, quickSort.topKFrequent(new int[]{1, 2}, 2));
    }
}