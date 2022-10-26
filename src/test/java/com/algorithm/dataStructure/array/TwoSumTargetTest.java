package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTargetTest {

    @Test
    public void twoSum() {
        TwoSumTarget.SetSolution setSolution = new TwoSumTarget.SetSolution();
        assertArrayEquals(new int[]{2, 7}, setSolution.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{10, 30}, setSolution.twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40));
        TwoSumTarget.TwoPointerSolution twoPointerSolution = new TwoSumTarget.TwoPointerSolution();
        assertArrayEquals(new int[]{2, 7}, twoPointerSolution.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{10, 30}, twoPointerSolution.twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40));
    }
}