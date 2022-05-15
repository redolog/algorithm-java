package com.algorithm.dataStructure.matrix;

import junit.framework.TestCase;
import org.junit.Assert;

public class SetMatrixZerosTest extends TestCase {

    public void testSetZeroesZeroRowCol() {

        Assert.assertArrayEquals(new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}, SetMatrixZeros.setZeroesBruteForce(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}));
    }
}