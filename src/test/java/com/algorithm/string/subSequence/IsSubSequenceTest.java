package com.algorithm.string.subSequence;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsSubSequenceTest {

    @Test
    public void isSubsequence() {
        IsSubSequence service = new IsSubSequence();
        assertTrue(service.isSubsequence("abc", "ahbgdc"));
        assertFalse(service.isSubsequence("axc", "ahbgdc"));
        assertTrue(service.isSubsequence2("abc", "ahbgdc"));
        assertFalse(service.isSubsequence2("axc", "ahbgdc"));
    }
}