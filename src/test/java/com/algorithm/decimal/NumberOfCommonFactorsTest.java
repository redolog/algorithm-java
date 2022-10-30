package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfCommonFactorsTest {

    @Test
    public void commonFactors() {
        NumberOfCommonFactors.LoopSolution loopSolution = new NumberOfCommonFactors.LoopSolution();
        assertEquals(4, loopSolution.commonFactors(12, 6));
        assertEquals(2, loopSolution.commonFactors(25, 30));
        NumberOfCommonFactors.StreamSolution streamSolution = new NumberOfCommonFactors.StreamSolution();
        assertEquals(4, streamSolution.commonFactors(12, 6));
        assertEquals(2, streamSolution.commonFactors(25, 30));
    }
}