package com.algorithm.dataStructure.array.app.count;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountNicePairsInAnArrayTest {

    @Test
    public void countNicePairs() {
        CountNicePairsInAnArray.BFSolution bfSolution = new CountNicePairsInAnArray.BFSolution();
        assertEquals(2, bfSolution.countNicePairs(new int[]{42, 11, 1, 97}));
        assertEquals(4, bfSolution.countNicePairs(new int[]{13, 10, 35, 24, 76}));
        CountNicePairsInAnArray.CntDPSolution cntDPSolution = new CountNicePairsInAnArray.CntDPSolution();
        assertEquals(2, cntDPSolution.countNicePairs(new int[]{42, 11, 1, 97}));
        assertEquals(4, cntDPSolution.countNicePairs(new int[]{13, 10, 35, 24, 76}));
    }
}