package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Matrix01Test {

    Matrix01 service = new Matrix01();

    @Test
    public void updateMatrix() {
        assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, service.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}, service.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
    }

    @Test
    public void updateMatrixBFS2() {
        assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, service.updateMatrixBFS2(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}, service.updateMatrixBFS2(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
        assertArrayEquals(new int[][]{{0, 1, 0, 1, 2}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}}, service.updateMatrixBFS2(new int[][]{{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}}));

    }
}