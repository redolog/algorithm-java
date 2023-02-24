package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MakeArrayZeroBySubtractingEqualAmountsTest {

    @Test
    public void minimumOperations() {
        MakeArrayZeroBySubtractingEqualAmounts.BucketSortSolution bucketSortSolution = new MakeArrayZeroBySubtractingEqualAmounts.BucketSortSolution();
        assertEquals(3, bucketSortSolution.minimumOperations(new int[]{1, 5, 0, 3, 5}));
        assertEquals(0, bucketSortSolution.minimumOperations(new int[]{0}));
        MakeArrayZeroBySubtractingEqualAmounts.SetSolution setSolution = new MakeArrayZeroBySubtractingEqualAmounts.SetSolution();
        assertEquals(3, setSolution.minimumOperations(new int[]{1, 5, 0, 3, 5}));
        assertEquals(0, setSolution.minimumOperations(new int[]{0}));
    }
}