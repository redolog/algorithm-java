package com.algorithm.lookup;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class TopKFrequentElementsTest {

    @Test
    public void topKFrequent() {
        TopKFrequentElements.MinHeap minHeap = new TopKFrequentElements.MinHeap();
        assertArrayEquals(new int[]{2, 1}, minHeap.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[]{1}, minHeap.topKFrequent(new int[]{1}, 1));
        TopKFrequentElements.QuickSort quickSort = new TopKFrequentElements.QuickSort();
        assertArrayEquals(new int[]{1, 2}, quickSort.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[]{1}, quickSort.topKFrequent(new int[]{1}, 1));
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2), Arrays.stream(quickSort.topKFrequent(new int[]{1, 2}, 2)).boxed().collect(Collectors.toList())));
    }
}