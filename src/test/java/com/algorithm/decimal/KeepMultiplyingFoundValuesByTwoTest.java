package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeepMultiplyingFoundValuesByTwoTest {

    @Test
    public void findFinalValue() {
        KeepMultiplyingFoundValuesByTwo.SetSolution setSolution = new KeepMultiplyingFoundValuesByTwo.SetSolution();
        assertEquals(24, setSolution.findFinalValue(new int[]{5, 3, 6, 1, 12}, 3));
        assertEquals(4, setSolution.findFinalValue(new int[]{2, 7, 9}, 4));
        KeepMultiplyingFoundValuesByTwo.BF bf = new KeepMultiplyingFoundValuesByTwo.BF();
        assertEquals(24, bf.findFinalValue(new int[]{5, 3, 6, 1, 12}, 3));
        assertEquals(4, bf.findFinalValue(new int[]{2, 7, 9}, 4));
        KeepMultiplyingFoundValuesByTwo.Sort sort = new KeepMultiplyingFoundValuesByTwo.Sort();
        assertEquals(24, sort.findFinalValue(new int[]{5, 3, 6, 1, 12}, 3));
        assertEquals(4, sort.findFinalValue(new int[]{2, 7, 9}, 4));
    }
}