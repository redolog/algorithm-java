package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ZeroMatrixLcciTest {

    @Test
    public void setZeroes() {
        ZeroMatrixLcci.RowCol0AdditionalArr rowCol0AdditionalArr = new ZeroMatrixLcci.RowCol0AdditionalArr();
        assertArrayEquals(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}, rowCol0AdditionalArr.setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        assertArrayEquals(new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}, rowCol0AdditionalArr.setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}));
        ZeroMatrixLcci.RowCol0WithinArr rowCol0WithinArr = new ZeroMatrixLcci.RowCol0WithinArr();
        assertArrayEquals(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}, rowCol0WithinArr.setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        assertArrayEquals(new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}, rowCol0WithinArr.setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}));
    }
}