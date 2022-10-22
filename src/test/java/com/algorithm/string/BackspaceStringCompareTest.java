package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BackspaceStringCompareTest {

    @Test
    public void backspaceCompare() {
        BackspaceStringCompare.StackSolution stackSolution = new BackspaceStringCompare.StackSolution();
        assertTrue(stackSolution.backspaceCompare("ab#c", "ad#c"));
        assertTrue(stackSolution.backspaceCompare("ab##", "c#d#"));
        assertTrue(stackSolution.backspaceCompare("y#fo##f", "y#f#o##f"));
        assertFalse(stackSolution.backspaceCompare("a#c", "b"));
    }
}