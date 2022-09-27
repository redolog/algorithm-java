package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckPermutationLcciTest {

    @Test
    public void checkPermutation() {
        CheckPermutationLcci service = new CheckPermutationLcci();
        assertTrue(service.checkPermutation("abc", "bca"));
        assertFalse(service.checkPermutation("abc", "bad"));
    }
}