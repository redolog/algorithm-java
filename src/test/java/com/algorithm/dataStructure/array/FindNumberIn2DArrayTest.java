package com.algorithm.dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

public class FindNumberIn2DArrayTest {

    FindNumberIn2DArray service = new FindNumberIn2DArray();

    @Test
    public void searchMatrix() {
        int[][] matrix1 = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        Assert.assertTrue(service.searchMatrixBruteForce(matrix1, 5));
        int[][] matrix2 = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        Assert.assertFalse(service.searchMatrixBruteForce(matrix2, 20));
        int[][] matrix3 = {{-1, 3}};
        Assert.assertTrue(service.searchMatrixBruteForce(matrix3, 3));
        int[][] matrix4 = {{1, 3, 5}};
        Assert.assertFalse(service.searchMatrixWithRowBSearch(matrix4, -1));
        Assert.assertTrue(service.searchMatrixWithRowBSearch(matrix1, 5));
        Assert.assertFalse(service.searchMatrixWithRowBSearch(matrix2, 20));
        Assert.assertTrue(service.searchMatrixWithRowBSearch(matrix3, 3));
        Assert.assertFalse(service.searchMatrixWithRowBSearch(matrix4, -1));
        Assert.assertFalse(service.searchMatrixWithBSearch(matrix4, -1));
        Assert.assertTrue(service.searchMatrixWithBSearch(matrix1, 5));
        Assert.assertFalse(service.searchMatrixWithBSearch(matrix2, 20));
        Assert.assertTrue(service.searchMatrixWithBSearch(matrix3, 3));
        Assert.assertFalse(service.searchMatrixWithBSearch(matrix4, -1));
    }
}