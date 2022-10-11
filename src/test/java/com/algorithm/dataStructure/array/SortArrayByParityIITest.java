package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortArrayByParityIITest {

    @Test
    public void sortArrayByParityII() {
        SortArrayByParityII service = new SortArrayByParityII();
        assertArrayEquals(new int[]{4, 5, 2, 7}, service.sortArrayByParityII(new int[]{4, 2, 5, 7}));
        assertArrayEquals(new int[]{2, 3}, service.sortArrayByParityII(new int[]{2, 3}));
    }
}