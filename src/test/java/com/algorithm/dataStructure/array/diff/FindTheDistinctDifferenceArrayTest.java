package com.algorithm.dataStructure.array.diff;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindTheDistinctDifferenceArrayTest {

    @Test
    public void distinctDifferenceArray() {
        FindTheDistinctDifferenceArray service = new FindTheDistinctDifferenceArray();
        assertArrayEquals(new int[]{-3, -1, 1, 3, 5}, service.distinctDifferenceArray(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{-2, -1, 0, 2, 3}, service.distinctDifferenceArray(new int[]{3, 2, 3, 4, 2}));
        assertArrayEquals(new int[]{-3, -1, 1, 3, 5}, service.distinctDifferenceArray2(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{-2, -1, 0, 2, 3}, service.distinctDifferenceArray2(new int[]{3, 2, 3, 4, 2}));
    }
}