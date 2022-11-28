package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringIITest {

    @Test
    public void reverseStr() {
        ReverseStringII.BuilderSolution builderSolution = new ReverseStringII.BuilderSolution();
        assertEquals("bacdfeg", builderSolution.reverseStr("abcdefg", 2));
        assertEquals("bacd", builderSolution.reverseStr("abcd", 2));
        assertEquals("cbad", builderSolution.reverseStr("abcd", 3));
        ReverseStringII.CharArrSolution charArrSolution = new ReverseStringII.CharArrSolution();
        assertEquals("bacdfeg", charArrSolution.reverseStr("abcdefg", 2));
        assertEquals("bacd", charArrSolution.reverseStr("abcd", 2));
        assertEquals("cbad", charArrSolution.reverseStr("abcd", 3));
    }
}