package com.algorithm.dataStructure.array.slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumCostOfDeleteDuplicateContinuousCharsTest {

    @Test
    public void miniCost() {
        MinimumCostOfDeleteDuplicateContinuousChars service = new MinimumCostOfDeleteDuplicateContinuousChars();
        assertEquals(2, service.miniCost("abccbd", new int[]{0, 1, 2, 3, 4, 5}));
        assertEquals(3, service.miniCost("aabbcc", new int[]{1, 2, 1, 2, 1, 2}));
        assertEquals(12, service.miniCost("aaaa", new int[]{3, 4, 5, 6}));
        assertEquals(0, service.miniCost("ababa", new int[]{10, 5, 10, 5, 10}));
    }
}