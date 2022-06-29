package com.algorithm.dataStructure.matrix;

import org.junit.Assert;
import org.junit.Test;

public class SetMatrixZerosTest {

    @Test
    public void testSetZeroesZeroRowCol() {

        Assert.assertArrayEquals(new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}, SetMatrixZeros.setZeroesBruteForce(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}));
    }

    @Test
    public void setZeroesZeroRowCol() {
        SetMatrixZeros service = new SetMatrixZeros();
        Assert.assertArrayEquals(new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}, service.setZeroesZeroRowCol(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}));

    }
}