package com.algorithm.lookup.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindFirstAndLastElementInASortedArrayTest {

    @Test
    public void searchRange() {
        FindFirstAndLastElementInASortedArray service = new FindFirstAndLastElementInASortedArray();
        assertArrayEquals(new int[]{3, 4}, service.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, service.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        assertArrayEquals(new int[]{-1, -1}, service.searchRange(new int[]{}, 0));
    }
}