package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortedMergeLcciTest {

    @Test
    public void testMerge() {
        SortedMergeLcci service = new SortedMergeLcci();
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, service.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3));
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, service.merge2(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3));
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, service.merge3(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3));
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, service.merge4(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3));
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, service.merge5(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3));
    }
}