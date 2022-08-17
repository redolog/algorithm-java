package com.algorithm.lookup.bsearch.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindRightIntervalTest {

    @Test
    public void findRightInterval() {
        FindRightInterval service = new FindRightInterval();
        assertArrayEquals(new int[]{-1}, service.findRightInterval(new int[][]{{1, 2}}));
        assertArrayEquals(new int[]{-1, 0, 1}, service.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}}));
        assertArrayEquals(new int[]{-1, 2, -1}, service.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}}));
    }
}