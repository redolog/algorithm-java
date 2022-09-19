package com.algorithm.dataStructure.array.app.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortArrayByIncreasingFrequencyTest {

    @Test
    public void frequencySort() {
        SortArrayByIncreasingFrequency service = new SortArrayByIncreasingFrequency();
        assertArrayEquals(new int[]{3, 1, 1, 2, 2, 2}, service.frequencySort(new int[]{1, 1, 2, 2, 2, 3}));
        assertArrayEquals(new int[]{1, 3, 3, 2, 2}, service.frequencySort(new int[]{2, 3, 1, 3, 2}));
        assertArrayEquals(new int[]{5, -1, 4, 4, -6, -6, 1, 1, 1}, service.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1}));
        assertArrayEquals(new int[]{-53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, -53, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52}, service.frequencySort(new int[]{-53, -53, 52, 52, 52, 52, -53, -53, 52, -53, 52, 52, 52, -53, 52, 52, -53, 52, -53, 52, -53, 52, 52, 52, 52, 52, 52, 52, 52, 52, -53, 52, -53, 52, -53, 52, 52, 52, -53, -53, 52, -53, 52, 52, 52, 52, -53, -53, -53, -53, -53, 52, 52, -53, 52, -53, 52, 52, 52}));
    }
}