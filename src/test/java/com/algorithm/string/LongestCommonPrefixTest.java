package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefixTest {

    @Test
    public void longestCommonPrefix() {
        LongestCommonPrefix.Simulation simulation = new LongestCommonPrefix.Simulation();

        assertEquals("fl", simulation.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", simulation.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        assertEquals("fl", simulation.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", simulation.longestCommonPrefix(new String[]{}));
        assertEquals("", simulation.longestCommonPrefix(new String[]{""}));
        assertEquals("a", simulation.longestCommonPrefix(new String[]{"a"}));
        assertEquals("a", simulation.longestCommonPrefix(new String[]{"ab", "a"}));
    }
}