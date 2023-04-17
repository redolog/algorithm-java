package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class RowWithMaximumOnesTest {

    @Test
    public void rowAndMaximumOnes() {
        RowWithMaximumOnes.MapSolution mapSolution = new RowWithMaximumOnes.MapSolution();
        assertArrayEquals(new int[]{0, 1}, mapSolution.rowAndMaximumOnes(new int[][]{{0, 1}, {1, 0}}));
        assertArrayEquals(new int[]{1, 2}, mapSolution.rowAndMaximumOnes(new int[][]{{0, 0, 0}, {0, 1, 1}}));
        assertArrayEquals(new int[]{1, 2}, mapSolution.rowAndMaximumOnes(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
        RowWithMaximumOnes.OrderSolution orderSolution = new RowWithMaximumOnes.OrderSolution();
        assertArrayEquals(new int[]{0, 1}, orderSolution.rowAndMaximumOnes(new int[][]{{0, 1}, {1, 0}}));
        assertArrayEquals(new int[]{1, 2}, orderSolution.rowAndMaximumOnes(new int[][]{{0, 0, 0}, {0, 1, 1}}));
        assertArrayEquals(new int[]{1, 2}, orderSolution.rowAndMaximumOnes(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
    }
}