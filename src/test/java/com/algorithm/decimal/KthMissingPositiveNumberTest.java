package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthMissingPositiveNumberTest {

    @Test
    public void findKthPositive() {
        KthMissingPositiveNumber.SetSolution setSolution = new KthMissingPositiveNumber.SetSolution();
        assertEquals(9, setSolution.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        assertEquals(6, setSolution.findKthPositive(new int[]{1, 2, 3, 4}, 2));
        KthMissingPositiveNumber.TwoPointerSolution twoPointerSolution = new KthMissingPositiveNumber.TwoPointerSolution();
        assertEquals(1, twoPointerSolution.findKthPositive(new int[]{2, 3, 4, 7, 11}, 1));
        assertEquals(9, twoPointerSolution.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        assertEquals(6, twoPointerSolution.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }
}