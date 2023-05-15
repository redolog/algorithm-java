package com.algorithm.dataStructure.array.hash;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlipColumnsForMaximumNumberOfEqualRowsTest {

    @Test
    public void maxEqualRowsAfterFlips() {
        FlipColumnsForMaximumNumberOfEqualRows service = new FlipColumnsForMaximumNumberOfEqualRows();
        assertEquals(1, service.maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 1}}));
        assertEquals(2, service.maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 0}}));
        assertEquals(2, service.maxEqualRowsAfterFlips(new int[][]{{0, 0, 0}, {0, 0, 1}, {1, 1, 0}}));
    }
}