package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindTheWidthOfColumnsOfAGridTest {

    @Test
    public void findColumnWidth() {
        FindTheWidthOfColumnsOfAGrid service = new FindTheWidthOfColumnsOfAGrid();
        assertArrayEquals(new int[]{3}, service.findColumnWidth(new int[][]{{1}, {22}, {333}}));
        assertArrayEquals(new int[]{3, 1, 2}, service.findColumnWidth(new int[][]{{-15, 1, 3}, {15, 7, 12}, {5, 6, -2}}));
    }
}