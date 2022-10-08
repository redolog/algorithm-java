package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PeaksAndValleysLcciTest {

    @Test
    public void wiggleSort() {
        PeaksAndValleysLcci service = new PeaksAndValleysLcci();
        assertArrayEquals(new int[]{5, 1, 3, 2, 3}, service.wiggleSort(new int[]{5, 3, 1, 2, 3}));
        assertArrayEquals(new int[]{5, 1, 3, 2, 3}, service.wiggleSort2(new int[]{5, 3, 1, 2, 3}));
    }
}