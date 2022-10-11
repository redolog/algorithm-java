package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckIfOneStringSwapCanMakeStringsEqualTest {

    @Test
    public void areAlmostEqual() {
        CheckIfOneStringSwapCanMakeStringsEqual service = new CheckIfOneStringSwapCanMakeStringsEqual();
        assertTrue(service.areAlmostEqual("bank", "kanb"));
        assertTrue(service.areAlmostEqual("kelb", "kelb"));

        assertFalse(service.areAlmostEqual("attack", "defend"));
        assertFalse(service.areAlmostEqual("aa", "ac"));
        assertFalse(service.areAlmostEqual("abcd", "dcba"));
    }
}