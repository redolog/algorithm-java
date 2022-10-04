package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest {

    @Test
    public void checkOnesSegment() {
        CheckIfBinaryStringHasAtMostOneSegmentOfOnes service = new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
        assertFalse(service.checkOnesSegment("1001"));
        assertTrue(service.checkOnesSegment("110"));
        assertFalse(service.checkOnesSegment2("1001"));
        assertTrue(service.checkOnesSegment2("110"));
        assertFalse(service.checkOnesSegment3("1001"));
        assertTrue(service.checkOnesSegment3("110"));
    }
}