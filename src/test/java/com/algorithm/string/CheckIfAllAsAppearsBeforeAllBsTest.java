package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckIfAllAsAppearsBeforeAllBsTest {

    @Test
    public void checkString() {
        CheckIfAllAsAppearsBeforeAllBs.TwoPointerSolution twoPointerSolution = new CheckIfAllAsAppearsBeforeAllBs.TwoPointerSolution();
        assertTrue(twoPointerSolution.checkString("aaabbb"));
        assertTrue(twoPointerSolution.checkString("bbb"));
        assertFalse(twoPointerSolution.checkString("abab"));
    }
}