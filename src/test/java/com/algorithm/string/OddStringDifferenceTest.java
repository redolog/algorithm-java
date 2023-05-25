package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class OddStringDifferenceTest {

    @Test
    public void oddString() {
        OddStringDifference.MapSolution mapSolution = new OddStringDifference.MapSolution();
        assertEquals("abc", mapSolution.oddString(new String[]{"adc", "wzy", "abc"}));
        assertEquals("bob", mapSolution.oddString(new String[]{"aaa", "bob", "ccc", "ddd"}));
        OddStringDifference.StreamSolution streamSolution = new OddStringDifference.StreamSolution();
        assertEquals("abc", streamSolution.oddString(new String[]{"adc", "wzy", "abc"}));
        assertEquals("bob", streamSolution.oddString(new String[]{"aaa", "bob", "ccc", "ddd"}));
    }
}