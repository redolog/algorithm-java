package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddSpacesToStringTest {

    @Test
    public void addSpacesToString() {
        assertEquals(AddSpacesToString.addSpacesToString("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}), "Leetcode Helps Me Learn");
        assertEquals(AddSpacesToString.addSpacesToString("icodeinpython", new int[]{1, 5, 7, 9}), "i code in py thon");
        assertEquals(AddSpacesToString.addSpacesToString("spacing", new int[]{0, 1, 2, 3, 4, 5, 6}), " s p a c i n g");
    }
}