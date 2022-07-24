package com.algorithm.dataStructure.array.preSum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContiguousArrayTest {

    @Test
    public void findMaxLength() {
        ContiguousArray.PreSumArr preSumArr = new ContiguousArray.PreSumArr();
        assertEquals(2, preSumArr.findMaxLength(new int[]{0, 1}));
        assertEquals(2, preSumArr.findMaxLength(new int[]{0, 1, 0}));
        assertEquals(2, preSumArr.findMaxLength(new int[]{0, 1, 1}));
        assertEquals(6, preSumArr.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
        assertEquals(4, preSumArr.findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}));
        ContiguousArray.PreSum preSum = new ContiguousArray.PreSum();
        assertEquals(2, preSum.findMaxLength(new int[]{0, 1}));
        assertEquals(2, preSum.findMaxLength(new int[]{0, 1, 0}));
        assertEquals(2, preSum.findMaxLength(new int[]{0, 1, 1}));
        assertEquals(6, preSum.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
        assertEquals(4, preSum.findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}));
    }
}