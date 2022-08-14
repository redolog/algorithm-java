package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumScoreAfterSplittingAStringTest {

    @Test
    public void maxScore() {
        MaximumScoreAfterSplittingAString service = new MaximumScoreAfterSplittingAString();
        assertEquals(5, service.maxScore("011101"));
        assertEquals(5, service.maxScore("00111"));
        assertEquals(3, service.maxScore("1111"));
        assertEquals(1, service.maxScore("00"));
    }
}