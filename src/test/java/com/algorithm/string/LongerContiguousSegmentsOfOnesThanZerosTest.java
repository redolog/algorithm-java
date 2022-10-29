package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LongerContiguousSegmentsOfOnesThanZerosTest {

    @Test
    public void checkZeroOnes() {
        LongerContiguousSegmentsOfOnesThanZeros service = new LongerContiguousSegmentsOfOnesThanZeros();
        assertTrue(service.checkZeroOnes("1101"));
        assertFalse(service.checkZeroOnes("111000"));
    }
}