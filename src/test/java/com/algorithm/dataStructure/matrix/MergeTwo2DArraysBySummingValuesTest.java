package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwo2DArraysBySummingValuesTest {

    @Test
    public void mergeArrays() {
        MergeTwo2DArraysBySummingValues service = new MergeTwo2DArraysBySummingValues();
        assertArrayEquals(new int[][]{{1, 6}, {2, 3}, {3, 2}, {4, 6}}, service.mergeArrays(new int[][]{{1, 2}, {2, 3}, {4, 5}}, new int[][]{{1, 4}, {3, 2}, {4, 1}}));
        assertArrayEquals(new int[][]{{1, 3}, {2, 4}, {3, 6}, {4, 3}, {5, 5}}, service.mergeArrays(new int[][]{{2, 4}, {3, 6}, {5, 5}}, new int[][]{{1, 3}, {4, 3}}));
    }
}