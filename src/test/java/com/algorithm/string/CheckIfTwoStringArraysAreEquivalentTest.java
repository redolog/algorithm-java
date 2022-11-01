package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckIfTwoStringArraysAreEquivalentTest {

    @Test
    public void arrayStringsAreEqual() {
        CheckIfTwoStringArraysAreEquivalent.StringJoinSolution stringJoinSolution = new CheckIfTwoStringArraysAreEquivalent.StringJoinSolution();
        assertTrue(stringJoinSolution.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        assertTrue(stringJoinSolution.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
        assertFalse(stringJoinSolution.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
        CheckIfTwoStringArraysAreEquivalent.TwoPointerSolution twoPointerSolution = new CheckIfTwoStringArraysAreEquivalent.TwoPointerSolution();
        assertTrue(twoPointerSolution.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        assertTrue(twoPointerSolution.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
        assertFalse(twoPointerSolution.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
    }
}