package com.algorithm.dataStructure.array.diff;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DiffArrayTest {

    @Test
    public void diff2Origin() {
        int[][] ops = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        DiffArray diffArray = new DiffArray(5);
        for (int[] op : ops) {
            diffArray.rangeOp(op[0], op[1], op[2]);
        }
        assertArrayEquals(new int[]{-2, 0, 3, 5, 3}, diffArray.diff2Origin());
    }
}