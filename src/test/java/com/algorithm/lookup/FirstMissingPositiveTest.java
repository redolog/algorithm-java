package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstMissingPositiveTest {

    @Test
    public void testFirstMissingPositive() {
        FirstMissingPositive.Sort sort = new FirstMissingPositive.Sort();
        assertEquals(3, sort.firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(2, sort.firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(1, sort.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        FirstMissingPositive.SetSolution setSolution = new FirstMissingPositive.SetSolution();
        assertEquals(3, setSolution.firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(2, setSolution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(1, setSolution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        FirstMissingPositive.InplaceHash inplaceHash = new FirstMissingPositive.InplaceHash();
        assertEquals(3, inplaceHash.firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(2, inplaceHash.firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(1, inplaceHash.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

}