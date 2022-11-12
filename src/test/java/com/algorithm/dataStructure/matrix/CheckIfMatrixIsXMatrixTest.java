package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckIfMatrixIsXMatrixTest {

    @Test
    public void checkXMatrix() {
        CheckIfMatrixIsXMatrix service = new CheckIfMatrixIsXMatrix();
        assertTrue(service.checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}}));
        assertFalse(service.checkXMatrix(new int[][]{{5, 7, 0}, {0, 3, 1}, {0, 5, 0}}));
    }
}