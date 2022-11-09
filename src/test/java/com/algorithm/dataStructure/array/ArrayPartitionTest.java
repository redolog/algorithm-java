package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayPartitionTest {

    @Test
    public void arrayPairSum() {
        ArrayPartition service = new ArrayPartition();
        assertEquals(4, service.arrayPairSum(new int[]{1, 4, 3, 2}));
        assertEquals(9, service.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }
}