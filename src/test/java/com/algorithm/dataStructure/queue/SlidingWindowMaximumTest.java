package com.algorithm.dataStructure.queue;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SlidingWindowMaximumTest {

    @Test
    public void maxSlidingWindowWithMaxHeap() {
        SlidingWindowMaximum service = new SlidingWindowMaximum();
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, service.maxSlidingWindowWithMonotoneDeque(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertArrayEquals(new int[]{1}, service.maxSlidingWindowWithMonotoneDeque(new int[]{1}, 1));
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, service.maxSlidingWindowWithMaxHeap(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertArrayEquals(new int[]{1}, service.maxSlidingWindowWithMaxHeap(new int[]{1}, 1));
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, service.maxSlidingWindowBF(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertArrayEquals(new int[]{1}, service.maxSlidingWindowBF(new int[]{1}, 1));

    }
}