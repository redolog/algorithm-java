package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {

    @Test
    public void longestCommonSubsequence() {
        LongestCommonSubsequence service = new LongestCommonSubsequence();
        assertEquals(3, service.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, service.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, service.longestCommonSubsequence("abc", "def"));
    }
}