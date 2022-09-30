package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortArrayByParityTest {

    @Test
    public void sortArrayByParity() {
        SortArrayByParity service = new SortArrayByParity();
        assertArrayEquals(new int[]{4, 2, 1, 3}, service.sortArrayByParity(new int[]{3, 1, 2, 4}));
        assertArrayEquals(new int[]{0}, service.sortArrayByParity(new int[]{0}));
    }
}