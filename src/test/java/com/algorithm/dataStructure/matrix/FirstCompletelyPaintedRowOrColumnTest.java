package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstCompletelyPaintedRowOrColumnTest {

    @Test
    public void firstCompleteIndex() {
        FirstCompletelyPaintedRowOrColumn.MapSolution mapSolution = new FirstCompletelyPaintedRowOrColumn.MapSolution();
        assertEquals(2, mapSolution.firstCompleteIndex(new int[]{1, 3, 4, 2}, new int[][]{{1, 4}, {2, 3}}));
        assertEquals(3, mapSolution.firstCompleteIndex(new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9}, new int[][]{{3, 2, 5}, {1, 4, 6}, {8, 7, 9}}));
    }
}