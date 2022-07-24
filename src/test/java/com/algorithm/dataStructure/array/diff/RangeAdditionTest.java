package com.algorithm.dataStructure.array.diff;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RangeAdditionTest {

    @Test
    public void testRangeAddition() {
        RangeAddition.BF bf = new RangeAddition.BF();
        assertArrayEquals(new int[]{-2, 0, 3, 5, 3}, bf.getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}}));
        RangeAddition.DiffArray diffArray = new RangeAddition.DiffArray();
        assertArrayEquals(new int[]{-2, 0, 3, 5, 3}, diffArray.getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}}));
    }

}