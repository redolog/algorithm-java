package com.algorithm.dataStructure.tree.heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianFinderTest {

    @Test
    public void findMedian() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        assertEquals(3.0, medianFinder.findMedian(), 0);

        medianFinder.clear();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        assertEquals(2.5, medianFinder.findMedian(), 0);

    }
}