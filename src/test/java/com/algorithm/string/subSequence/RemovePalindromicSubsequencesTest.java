package com.algorithm.string.subSequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemovePalindromicSubsequencesTest {

    @Test
    public void removePalindromeSub() {
        RemovePalindromicSubsequences service = new RemovePalindromicSubsequences();
        assertEquals(1, service.removePalindromeSub("ababa"));
        assertEquals(2, service.removePalindromeSub("abb"));
        assertEquals(2, service.removePalindromeSub("baabb"));
    }
}