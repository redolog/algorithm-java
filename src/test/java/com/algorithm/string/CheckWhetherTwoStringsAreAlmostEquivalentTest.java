package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckWhetherTwoStringsAreAlmostEquivalentTest {

    @Test
    public void checkAlmostEquivalent() {
        CheckWhetherTwoStringsAreAlmostEquivalent service = new CheckWhetherTwoStringsAreAlmostEquivalent();
        assertFalse(service.checkAlmostEquivalent("aaaa", "bccb"));
        assertTrue(service.checkAlmostEquivalent("abcdeef", "abaaacc"));
        assertTrue(service.checkAlmostEquivalent("cccddabba", "babababab"));
    }
}