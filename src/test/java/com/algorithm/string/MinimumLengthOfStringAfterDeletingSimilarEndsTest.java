package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumLengthOfStringAfterDeletingSimilarEndsTest {

    @Test
    public void minimumLength() {
        MinimumLengthOfStringAfterDeletingSimilarEnds service = new MinimumLengthOfStringAfterDeletingSimilarEnds();
//        assertEquals(2, service.minimumLength("ca"));
//        assertEquals(0, service.minimumLength("cabaabac"));
        assertEquals(3, service.minimumLength("aabccabba"));
    }
}